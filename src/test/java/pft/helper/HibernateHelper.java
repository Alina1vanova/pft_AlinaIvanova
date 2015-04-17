package pft.helper;

import java.util.List;

import pft.data.ContactData;
import pft.data.GroupData;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pft.utils.SortedListOf;

import pft.utils.HibernateUtil;

public class HibernateHelper extends WebDriverBaseHelper {

    public HibernateHelper(ApplicationManager manager) {
        super(manager);
    }

    public SortedListOf<GroupData> listGroups() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            return new SortedListOf<GroupData>(
                    (List<GroupData>) session.createQuery("from GroupData").list());
        } finally {
            trans.commit();
        }
    }

    public SortedListOf<ContactData> listContacts() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        try {
            return new SortedListOf<ContactData>(
                    (List<ContactData>) session.createQuery("from ContactData").list());
        } finally {
            trans.commit();
        }
    }
}
