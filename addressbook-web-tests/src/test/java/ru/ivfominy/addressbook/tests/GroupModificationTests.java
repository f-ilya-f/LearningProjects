package ru.ivfominy.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ivfominy.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        //предусловие на создание группы если список текущих групп пуст
        if (app.group().list().size()==0) {
            app.group().create(new GroupData("test1", null, null));
        }
    }
    @Test
    public void testGroupModification() {
                List<GroupData> before = app.group().list();
        int index=before.size()-1;
        GroupData newGroup=new GroupData(before.get(index).getId(), "test1", "test2", "test3");
        app.group().modify(index, newGroup);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(newGroup);
        Comparator<? super GroupData> byId= (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
