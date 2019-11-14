package ru.ivfominy.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.ivfominy.addressbook.model.GroupData;
import ru.ivfominy.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
        Groups after = app.group().all();
        assertEquals(after.size(), before.size() + 1);
        assertThat(after, equalTo(
                before.withAdded(newGroup.withId(after.stream().mapToInt(g->g.getId()).max().getAsInt()))));
    }


}
