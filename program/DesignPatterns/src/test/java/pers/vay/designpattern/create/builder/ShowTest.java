package pers.vay.designpattern.create.builder;


import org.junit.jupiter.api.Test;
import pers.vay.designpattern.create.builder.after.Show;

public class ShowTest {
    @Test
    public void show_roles_look() {
        Show show = new Show();
        show.showRolesLook();
    }
}
