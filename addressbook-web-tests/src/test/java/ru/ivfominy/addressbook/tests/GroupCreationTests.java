package ru.ivfominy.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.ivfominy.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().groupPage();
        List<GroupData> before = app.group().list();
        //int before=app.getGroupHelper().getGroupCount();
        GroupData newGroup = new GroupData().withName("test2");
        app.group().create(newGroup);
        List<GroupData> after = app.group().list();
        //int after=app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after.size(), before.size() + 1);
        //Assert.assertEquals(after, before + 1);

        before.add(newGroup);
        Comparator<? super GroupData> byId= (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
