package mdl.sinlov.androidlog;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * adapter of log test
 * <pre>
 *     sinlov
 *
 *     /\__/\
 *    /`    '\
 *  ≈≈≈ 0  0 ≈≈≈ Hello world!
 *    \  --  /
 *   /        \
 *  /          \
 * |            |
 *  \  ||  ||  /
 *   \_oo__oo_/≡≡≡≡≡≡≡≡o
 *
 * </pre>
 * Created by "sinlov" on 16/6/16.
 */
public class LogTestAdapter extends BaseExpandableListAdapter {

    private List<String> groupArray;
    private List<List<String>> childArray;

    Activity activity;

    public LogTestAdapter(Activity activity, List<String> groupArray, List<List<String>> childArray) {
        this.groupArray = groupArray;
        this.childArray = childArray;
        this.activity = activity;
    }

    public Object getChild(int groupPosition, int childPosition) {
        return childArray.get(groupPosition).get(childPosition);
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    public int getChildrenCount(int groupPosition) {
        return childArray.get(groupPosition).size();
    }

    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        String string = childArray.get(groupPosition).get(childPosition);
        return getGenericView(string);
    }

    // group method stub
    public Object getGroup(int groupPosition) {
        return groupArray.get(groupPosition);
    }

    public int getGroupCount() {
        return groupArray.size();
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String string = groupArray.get(groupPosition);
        return getGenericView(string);
    }

    // View stub to create Group/Children 's View
    public TextView getGenericView(String string) {
        // Layout parameters for the ExpandableListView
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, 160);
        TextView text = new TextView(activity);
        text.setLayoutParams(layoutParams);
        // Center the text vertically
        text.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        // Set the text starting position
        text.setPadding(96, 0, 0, 0);
        text.setText(string);
        return text;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
