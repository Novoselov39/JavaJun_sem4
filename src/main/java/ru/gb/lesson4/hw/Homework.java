package ru.gb.lesson4.hw;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.gb.lesson4.entity.Author;
import ru.gb.lesson4.entity.AuthorBook;
import ru.gb.lesson4.entity.Book;


public class Homework {

  /**
   * Используя hibernate, создать таблицы:
   * 1. Post (публикация) (id, title)
   * 2. PostComment (комментарий к публикации) (id, text, post_id)
   *
   * Написать стандартные CRUD-методы: создание, загрузка, удаление.
   *
   * Доп. задания:
   * 1. * В сущностях post и postComment добавить поля timestamp с датами.
   * 2. * Создать таблицу users(id, name) и в сущностях post и postComment добавить ссылку на юзера.
   * 3. * Реализовать методы:
   * 3.1 Загрузить все комментарии публикации
   * 3.2 Загрузить все публикации по идентификатору юзера
   * 3.3 ** Загрузить все комментарии по идентификатору юзера
   * 3.4 **** По идентификатору юзера загрузить юзеров, под чьими публикациями он оставлял комменты.
   * // userId -> List<User>
   *
   *
   * Замечание:
   * 1. Можно использовать ЛЮБУЮ базу данных (например, h2)
   * 2. Если запутаетесь, приходите в группу в телеграме или пишите мне @inchestnov в личку.
   */

  public static void main(String[] args) {
      Configuration configuration = new Configuration();
      configuration.configure("HW_hibernate.cfg.xml"); // !!! иначе cfg.xml не прочитается
      try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
          // sessionFactory <-> connection
          withSession(sessionFactory);
//      withSessionCRUD(sessionFactory);
      }
  }
    private static void withSession(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            PostComment postComment= new PostComment();
            postComment.setId(1L);
            postComment.setText("PostComment");
            postComment.setPost_id(1L);

            Post post = new Post();
            post.setId(1L);
            post.setTitle("post");


            Transaction tx = session.beginTransaction();
            session.persist(post);
            session.persist(postComment);
            if (true) {
                throw new RuntimeException();
            }
            tx.commit();
        }

//    try (Session session = sessionFactory.openSession()) {
//      Author author = session.find(Author.class, 2L);
//      System.out.println(author);
//
//      for (Book book : author.getBooks()) {
//        System.out.println(book);
//      }
//    }
    }

}
