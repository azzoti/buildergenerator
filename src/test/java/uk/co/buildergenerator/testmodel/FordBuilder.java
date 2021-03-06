package uk.co.buildergenerator.testmodel;


public class FordBuilder extends uk.co.buildergenerator.testmodel.CustomerCarBuilder<FordBuilder> {

    public static FordBuilder aFord() {
        return new FordBuilder();
    }
    
    private uk.co.buildergenerator.testmodel.Ford target = new uk.co.buildergenerator.testmodel.Ford();

    public FordBuilder() {}

    public FordBuilder withFordSpecificProperty(java.lang.String fordSpecificProperty) {
        getTarget().setFordSpecificProperty(fordSpecificProperty);
        return this;
    }

    public FordBuilder withGenericCarProperty(java.lang.String genericCarProperty) {
        getTarget().setGenericCarProperty(genericCarProperty);
        return this;
    }

    protected uk.co.buildergenerator.testmodel.Ford getTarget() {
        return target;
    }

    public uk.co.buildergenerator.testmodel.Ford build() {
        return getTarget();
    }
    
}

