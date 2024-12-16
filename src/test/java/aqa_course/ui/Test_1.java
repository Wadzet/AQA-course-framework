package aqa_course.ui;

import aqa_course.bo.GoogleBO;
import org.testng.annotations.Test;

public class Test_1 {
    @Test
    void Test_method_1 () {
    GoogleBO googleBO = new GoogleBO ();
    googleBO.search("something").checkResults();
    }
}
