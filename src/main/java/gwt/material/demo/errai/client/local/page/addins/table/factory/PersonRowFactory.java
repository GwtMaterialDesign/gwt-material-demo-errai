package gwt.material.demo.errai.client.local.page.addins.table.factory;

import gwt.material.demo.errai.client.local.page.addins.table.model.Person;
import gwt.material.design.client.data.component.RowComponent;
import gwt.material.design.client.data.factory.RowComponentFactory;

public class PersonRowFactory extends RowComponentFactory<Person> {

    @Override
    public RowComponent<Person> generate(Person model) {
        // We won't change the way it loads the RowComponent
        return super.generate(model);
    }

    @Override
    public String getCategory(Person model) {
        // We want to override the standard category retrieval
        // This is where we can define a models category.
        // This is useful when we don't want to pollute our
        // object models with the interface HasDataCategory.
        return model.getCategory();
    }
}
