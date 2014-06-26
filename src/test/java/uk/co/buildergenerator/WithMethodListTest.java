package uk.co.buildergenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.junit.Test;

import uk.co.buildergenerator.testmodel.BooleanPropertyBean;
import uk.co.buildergenerator.testmodel.House;
import uk.co.buildergenerator.testmodel.Target;

public class WithMethodListTest {
    
    
    private static final String BUILDER_PACKAGE = "builder.package";
    
    @Test
    public void targetWithStringProperty() throws Exception {
        
        List<WithMethod> withMethodList = new WithMethodList(House.class, BUILDER_PACKAGE);
        WithMethod actualWithMethod = find(withMethodList, "name");
        WithMethod expectedWithMethod = TestUtils.createWithMethod("name", House.class, BUILDER_PACKAGE);
        assertTrue(EqualsBuilder.reflectionEquals(expectedWithMethod, actualWithMethod));
    }

    @Test
    public void targetWithListOfStringsProperty() throws Exception {
        
        List<WithMethod> withMethodList = new WithMethodList(Target.class, BUILDER_PACKAGE);
        WithMethod actualWithMethod = find(withMethodList, "month");
        WithMethod expectedWithMethod = TestUtils.createWithMethod("months", Target.class, BUILDER_PACKAGE);
        assertTrue(EqualsBuilder.reflectionEquals(expectedWithMethod, actualWithMethod));
    }

    @Test
    public void targetWithNonJavaLangPropertyRequiringBuilder() throws Exception {
        
        List<WithMethod> withMethodList = new WithMethodList(Target.class, BUILDER_PACKAGE);
        WithMethod actualWithMethod = find(withMethodList, "delegate");
        WithMethod expectedWithMethod = TestUtils.createWithMethod("delegate", Target.class, BUILDER_PACKAGE);
        assertTrue(EqualsBuilder.reflectionEquals(expectedWithMethod, actualWithMethod));
    }

    @Test
    public void targetWithListOfNonJavaLangPropertyRequiringBuilders() throws Exception {
        
        List<WithMethod> withMethodList = new WithMethodList(Target.class, BUILDER_PACKAGE);
        WithMethod actualWithMethod = find(withMethodList, "hostess");
        WithMethod expectedWithMethod = TestUtils.createWithMethod("hostesses", Target.class, BUILDER_PACKAGE);
        assertTrue(EqualsBuilder.reflectionEquals(expectedWithMethod, actualWithMethod));
    }

    @Test
    public void targetWithMulitplePropertiesOfDifferentTypes() throws Exception {
        
        List<WithMethod> withMethodList = new WithMethodList(Target.class, BUILDER_PACKAGE);
        assertEquals(8, withMethodList.size());
    }

    @Test
    public void targetWithBooleanPrimitiveProperty() throws Exception {
        
        List<WithMethod> withMethodList = new WithMethodList(BooleanPropertyBean.class, BUILDER_PACKAGE);
        WithMethod actualWithMethod = find(withMethodList, "theBoolean");
        WithMethod expectedWithMethod = TestUtils.createWithMethod("theBoolean", BooleanPropertyBean.class, BUILDER_PACKAGE);
        assertTrue(EqualsBuilder.reflectionEquals(expectedWithMethod, actualWithMethod));
    }

    private WithMethod find(List<WithMethod> withMethodList, String parameterName) {
        for (WithMethod candidateWithMethod : withMethodList) {
            if (parameterName.equals(candidateWithMethod.getParameterName())) {
                return candidateWithMethod;
            }
        }
        return null;
    }

}
