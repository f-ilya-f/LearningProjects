package ru.ivfominy.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.ivfominy.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().gotoGroupPage();
        //предусловие на создание группы если список текущих групп пуст
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
    }
    @Test
    public void testGroupDeletion() throws Exception {
              List<GroupData> before = app.getGroupHelper().getGroupList();
                app.getGroupHelper().selectGroup(0);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
      List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);   //сравнение количества групп

        before.remove(0);
          Assert.assertEquals(after, before);   //сравнение групп по содержанию

    }

}
