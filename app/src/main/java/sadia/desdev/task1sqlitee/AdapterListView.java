package sadia.desdev.task1sqlitee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdapterListView extends ArrayAdapter
{
    List list=new ArrayList();

    public AdapterListView(Context context, int resource) {
        super(context, resource);
    }


    public void add(namelist object) {
        list.add(object);
        super.add(object);

    }

    @Override
    public int getCount() {
        return super.getCount();
    }


    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(getContext()).inflate(R.layout.cardview,parent,false);
        return view ;

    }
}
