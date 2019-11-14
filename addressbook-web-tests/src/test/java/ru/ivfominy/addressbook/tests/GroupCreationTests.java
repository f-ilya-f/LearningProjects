package ru.ivfominy.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.ivfominy.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
        //int before=app.getGroupHelper().getGroupCount();
        GroupData newGroup = new GroupData().withName("test2");
        app.group().create(newGroup);
        Set<GroupData> after = app.group().all();
        //int after=app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after.size(), before.size() + 1);
        //Assert.assertEquals(after, before + 1);

        newGroup.withId(after.stream().mapToInt(g->g.getId()).max().getAsInt());
        before.add(newGroup);
                Assert.assertEquals(before, after);
    }


}
