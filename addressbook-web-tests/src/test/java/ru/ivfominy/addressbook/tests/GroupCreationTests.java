package ru.ivfominy.addressbook.tests;

import org.testng.annotations.Test;
import ru.ivfominy.addressbook.model.GroupData;
import ru.ivfominy.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().groupPage();
        Groups before = app.group().all();
        //int before=app.getGroupHelper().getGroupCount();
        GroupData newGroup = new GroupData().withName("test2");
        app.group().create(newGroup);
        assertThat(app.group().count(), equalTo(before.size()+1));
        Groups after = app.group().all();
        assertThat(after, equalTo(
                before.withAdded(newGroup.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));
    }

    @Test
    public void testBadGroupCreation() throws Exception {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData newGroup = new GroupData().withName("test2'");
        app.group().create(newGroup);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }
}
