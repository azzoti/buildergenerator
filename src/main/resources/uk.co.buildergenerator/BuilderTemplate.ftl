<#if !generationGapBaseBuilder>package ${builderPackage};</#if>
<#if generationGapBaseBuilder>package ${generationGapBaseBuilderPackage};</#if>

public class ${targetClass}<#if !generationGapBaseBuilder>Builder</#if><#if generationGapBaseBuilder>BaseBuilder<T extends ${generationGapBaseBuilderPackage}.${targetClass}BaseBuilder<T>></#if> <#if generationGapBuilder>extends ${generationGapBaseBuilderPackage}.${targetClass}BaseBuilder<${targetClass}Builder> </#if><#if !generationGapBuilder><#if superClassSpecified>extends ${superClass} </#if></#if><#if !generationGapBuilder>implements ${builderInterface}<${fullyQualifiedTargetClass}> </#if>{
    <#if !generationGapBaseBuilder>
    public static ${targetClass}Builder ${factoryMethodPrefix}${targetClass}() {
        return new ${targetClass}Builder();
    }</#if><#if !generationGapBuilder>    
    private ${fullyQualifiedTargetClass} target = new ${fullyQualifiedTargetClass}();
    
    public ${targetClass}<#if generationGapBaseBuilder>Base</#if>Builder() {}
    
    <#list withMethodList as withMethod>
    public <#if generationGapBaseBuilder>T</#if><#if !generationGapBaseBuilder>${targetClass}Builder</#if> with${withMethod.propertyName}(${withMethod.parameterType} ${withMethod.parameterName}) {
    <#if withMethod.collection>
    <#if withMethod.collectionNeedsInitialising>
        if (getTarget().${withMethod.collectionGetterMethodName}() == null) {
        <#if !withMethod.builder>
            getTarget().${withMethod.collectionSetterMethodName}(new ${withMethod.collectionType}<${withMethod.parameterType}>());
        </#if>
        <#if withMethod.builder>
            getTarget().${withMethod.collectionSetterMethodName}(new ${withMethod.collectionType}<${withMethod.builderTargetType}>());
        </#if>
        }        
    </#if>
        getTarget().${withMethod.collectionMethodSettingInvocation}(${withMethod.parameterName}<#if withMethod.builder>.build()</#if>);
    </#if>
    <#if !withMethod.collection>
        getTarget().set${withMethod.propertyName}(${withMethod.parameterName}<#if withMethod.builder>.build()</#if>);
    </#if>
        return <#if generationGapBaseBuilder>(T) </#if>this;
    }
    
    </#list>
    protected ${fullyQualifiedTargetClass} getTarget() {
        return target;
    }
    
    public ${fullyQualifiedTargetClass} build() {
        return getTarget();
    }</#if>
}
