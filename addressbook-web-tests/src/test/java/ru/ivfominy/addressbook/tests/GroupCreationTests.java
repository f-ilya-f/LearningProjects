package ru.ivfominy.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.ivfominy.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        //int before=app.getGroupHelper().getGroupCount();
        GroupData newGroup = new GroupData("test1", null, null);
        app.getGroupHelper().createGroup(newGroup);
        List<GroupData> after = app.getGroupHelper().getGroupList();
        //int after=app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after.size(), before.size() + 1);
        //Assert.assertEquals(after, before + 1);

        int max = 0;
        for (GroupData g : after) {
            if (g.getId() > max)
                max = g.getId();
        }
        newGroup.setId(max);
        before.add(newGroup);
        Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));
    }


}
