package edu.fudan.langlab.gxt.client.component.form.factory.tree;

import java.util.Collection;

import com.google.common.collect.Lists;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.tree.Tree;
import com.sencha.gxt.widget.core.client.tree.Tree.CheckCascade;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider.ContentChangedListener;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IMultiValueSelector;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

import edu.fudan.langlab.gxt.client.component.KeyProvider;
import edu.fudan.langlab.gxt.client.component.form.factory.Forms;
import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeContentProvider;

public class CheckboxTreeMultiSelector<T> implements IMultiValueSelector<T> {
	private FieldLabel label;
	private IObjectNameProvider nameProvider;
	private Tree<T, String> tree;
	private TreeStore<T> store = new TreeStore<T>(new KeyProvider<T>());
	private ITreeContentProvider<T> treeContentProvider;

	public CheckboxTreeMultiSelector(String id, final String title,
			Boolean isRequired, ITreeContentProvider<T> treeContentPrivider,RuntimeGinjector runtimeGinjector) {
		this.treeContentProvider = treeContentPrivider;
		this.nameProvider = runtimeGinjector.getObjectNameProvider();
		tree = new Tree<T, String>(store, new ValueProvider<T, String>() {

			@Override
			public String getValue(T object) {
				return nameProvider.getName(object);
			}

			@Override
			public void setValue(T object, String value) {
			}

			@Override
			public String getPath() {
				return "name";
			}
		});
		tree.setCheckable(true);
		tree.setCheckStyle(CheckCascade.PARENTS);
		
		if (isRequired) {
			label = new FieldLabel(tree);
			label.setHTML(Forms.toRequiredTitle(title));
		} else
			label = new FieldLabel(tree, title);
		
	}

	@Override
	public Collection<T> getValue() {
		return tree.getCheckedSelection();
	}

	@Override
	public void addValueChangedListener(
			ValueChangedListener<Collection<T>> listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValue(Collection<T> value) {
		tree.setCheckedSelection(Lists.newArrayList(value));
	}

	@Override
	public FieldLabel asWidget() {
		return label;
	}

	@Override
	public void setContentProvider(final ContentProvider<T> provider) {

		updateContents(provider);

		provider.addContentChangedListener(new ContentChangedListener() {

			@Override
			public void onContentChanged() {
				updateContents(provider);

			}
		});
	}

	private void updateContents(ContentProvider<T> provider) {
		store.clear();
		for (T element : treeContentProvider.getRootElements(provider
				.getContents())) {
			store.add(element);
			processTree(element, provider);
		}
//		tree.expandAll();
	}

	private void processTree(T parent, ContentProvider<T> contentProvider) {
		for (T element : treeContentProvider.getChildren(parent,
				contentProvider.getContents())) {
			store.add(parent, element);
			processTree(element, contentProvider);
		}
	}

}
