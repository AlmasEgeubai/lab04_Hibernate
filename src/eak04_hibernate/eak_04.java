package eak04_hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.book;
import org.hibernate.criterion.Restrictions;

public class eak_04 {

    public static void main(String[] args) {

        Session book1 = connection.Controller.getSessionFactory().openSession();
        Transaction trans = book1.beginTransaction();

        System.out.println("Данные из таблицы:");
        list(book1.createCriteria(pojos.book.class).list());

        System.out.println("Добавление новых данных в таблицу.");
        //Сохранение данных в таблицу
        book1.save(new pojos.book("22.05.2020", "Игорь", "Кокшетау", "152565"));
        book1.save(new pojos.book("23.07.2020", "Марат", "Астана", "561525"));
        book1.save(new pojos.book("22.09.2020", "Альберт", "Астана", "625215"));
        book1.save(new pojos.book("23.12.2019", "Олег", "Павлодар", "585759"));
//                          ( date, `name`, `city`, num) VALUES ("10.01.2019", "da", "Астана", "3213213323");
//                              ( date, `name`, `city`, num) VALUES ("22.04.2018", "da", "Астана", "1232131232");
//                             ( date, `name`, `city`, num) VALUES ("21.04.2018", "ya", "Павлодар", "3213213213");
        System.out.println("Обновлённые данные таблицы:");
        list(book1.createCriteria(pojos.book.class).list());

        System.out.println("Удаление записи, где имя - 'Марат'.");
        pojos.book sunny = (pojos.book) book1.createCriteria(pojos.book.class)
                .add(Restrictions.eq("name", "Марат"))
                .uniqueResult();
        book1.delete(sunny);
        list(book1.createCriteria(pojos.book.class).list());

        System.out.println("Изменение имени с 'Олег' на 'Данил'");
        pojos.book murky = (pojos.book) book1.createCriteria(pojos.book.class)
                .add(Restrictions.eq("name", "Олег"))
                .uniqueResult();
        murky.setName("Данил");
        book1.update(murky);
        list(book1.createCriteria(pojos.book.class).list());

        //Изменение данных во 2 записи - Александр.
        System.out.println("Изменение данных во 2 записи с именем - Александр.");
        pojos.book bookD2 = (pojos.book) book1.load(pojos.book.class, 2);
        bookD2.setDate("20.02.2020");
        bookD2.setNum("555555");
        bookD2.setName("Ян");

        book1.update(bookD2);
        System.out.println("Обновлённые данные таблицы:");
        list(book1.createCriteria(pojos.book.class).list());

        //Удаление 5 записи - Альберт из таблицы.
        System.out.println("Удаление 1 записи c именем - Павел из таблицы.");
        pojos.book bookD1 = (pojos.book) book1.load(pojos.book.class, 1);
        
        book1.delete(bookD1);
        
        System.out.println("Конечное состояние таблицы:");
        list(book1.createCriteria(pojos.book.class).list());

        book1.close();
        System.exit(0);
        trans = null;

    }

    private static void list(List<book> nums) {
       nums.forEach(System.out::println);
        System.out.println("");
    }
}
