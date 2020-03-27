package com.example.colledge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AssignmentEditor extends AppCompatActivity {
    Course active;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_editor);
        Intent intent = getIntent();
        active = (Course)intent.getSerializableExtra("activeCourse");

        //updateAll();
    }

    public void updateAll(){
        String a = active.allAssignments();
        TextView viewer = findViewById(R.id.assignmentViewer);
        viewer.setText(a);
    }

    public void nextAssign(View view){
        String a = active.nextAsg();
        TextView viewer = findViewById(R.id.currAssignViewer);
        viewer.setText(a);
    }

    public void prevAssign(View view){
        String a = active.prevAsg();
        TextView viewer = findViewById(R.id.currAssignViewer);
        viewer.setText(a);
    }

    public void removeAssign(View view){
        active.removeCurrAssignment();
        updateAll();
        nextAssign(findViewById(R.id.button19));

    }

    public void addAssign(View view){
        TextView nv = findViewById(R.id.asgName);
        String name = nv.getText().toString();

        TextView tv = findViewById(R.id.asgType);
        String type = tv.getText().toString();

        TextView pv = findViewById(R.id.asgPP);
        String poss = pv.getText().toString();

        TextView ev = findViewById(R.id.asgPE);
        String earned = ev.getText().toString();

        active.addAssignment(name,type, poss, earned);
        updateAll();

    }
}
