package wissenstest;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Database {

    private EntityManagerFactory emf;
    private EntityManager em;

    public Database() {
        try {
            emf = Persistence.createEntityManagerFactory("WissenstestPU");
            em = emf.createEntityManager();
            System.out.println("Connected to Database");        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void registerObject(Object entity) {
        //if(!existing){     //toDo: Check if Object exists
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        /*}else{
            System.err.println("Object already exists.");
        }*/
    }

    public void registerQuestionAndAnswer(Question question, List<Answer> answers) {
        //if(!existing){     //toDo: Check if Object exists        
        em.getTransaction().begin();
        em.persist(question);
        for (int i = 0; i < answers.size(); i++) {
            question.getAnswers().get(i).setQuestion(question);
            em.persist(question.getAnswers().get(i));
        }
        em.getTransaction().commit();
        /*}else{
            System.err.println("Object already exists.");
        }*/
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        emf = entityManagerFactory;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void setEntityManager(EntityManager entityManager) {
        em = entityManager;
    }

    //overwritten in order of prof
    private EntityManagerFactory createEntityManagerFactory() {
        try {
            Properties properties = new Properties();
            String path = System.getProperty("user.home");
            File propertiesFile = new File(path, "db2praktikum.properties");
            System.out.println("Looking for Properties File in " + propertiesFile.getAbsolutePath());
            if (propertiesFile.exists()) {
                properties.load(new FileInputStream(propertiesFile));
            }
            return Persistence.createEntityManagerFactory("WissenstestPU", properties);
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
