package ru.ivfominy.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.ivfominy.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        //предусловие на создание группы если список текущих групп пуст
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        int howGroupModificate=before.size()-1;
        app.getGroupHelper().selectGroup(howGroupModificate);
        app.getGroupHelper().initGroupModification();
        GroupData newGroup=new GroupData(before.get(howGroupModificate).getId(), "test1", "test2", "test3");
        app.getGroupHelper().fillGroupForm(newGroup);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(howGroupModificate);
        before.add(newGroup);
        Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));
    }

}
