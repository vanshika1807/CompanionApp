package com.example.admincollegeapp.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.admincollegeapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {
    FloatingActionButton fab;
    private RecyclerView csDepartment, lawDepartment, businessDepartment,placementDepartment, examDepartment;
    private LinearLayout csNoData, lawNoData, businessNoData, placementNoData ,examNoData;
    private List<TeacherData> list1,list2,list3,list4,list5;

    private TeacherAdapter adapter;
    private DatabaseReference reference,dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        csDepartment = findViewById(R.id.csDepartment);
        lawDepartment = findViewById(R.id.lawDepartment);
        businessDepartment = findViewById(R.id.businessDepartment);
        placementDepartment = findViewById(R.id.placementDepartment);
        examDepartment = findViewById(R.id.examDepartment);


        csNoData = findViewById(R.id.csNoData);
        lawNoData = findViewById(R.id.lawNoData);
        businessNoData = findViewById(R.id.businessNoData);
        placementNoData = findViewById(R.id.placementNoData);
        examNoData = findViewById(R.id.examNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        csDepartment();
        lawDepartment();
        businessDepartment();
        placementDepartment();
        examDepartment();


        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateFaculty.this,AddTeacher.class));
            }
        });
    }

    private void csDepartment() {
        dbRef = reference.child("Computer Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 =  new ArrayList<>();
                if(!dataSnapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);

                }else{
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);

                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list1, UpdateFaculty.this,"Computer Science");
                    csDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void lawDepartment() {
        dbRef = reference.child("Law");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 =  new ArrayList<>();
                if(!dataSnapshot.exists()){
                    lawNoData.setVisibility(View.VISIBLE);
                    lawDepartment.setVisibility(View.GONE);

                }else{
                    lawNoData.setVisibility(View.GONE);
                    lawDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);

                    }
                    lawDepartment.setHasFixedSize(true);
                    lawDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list2, UpdateFaculty.this,"Law");
                    lawDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void businessDepartment() {
        dbRef = reference.child("Business");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 =  new ArrayList<>();
                if(!dataSnapshot.exists()){
                    businessNoData.setVisibility(View.VISIBLE);
                    businessDepartment.setVisibility(View.GONE);

                }else{
                    businessNoData.setVisibility(View.GONE);
                    businessDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);

                    }
                    businessDepartment.setHasFixedSize(true);
                    businessDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list3, UpdateFaculty.this,"Business");
                    businessDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void placementDepartment() {
        dbRef = reference.child("Placement Cell");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 =  new ArrayList<>();
                if(!dataSnapshot.exists()){
                    placementNoData.setVisibility(View.VISIBLE);
                    placementDepartment.setVisibility(View.GONE);

                }else{
                    placementNoData.setVisibility(View.GONE);
                    placementDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);

                    }
                    placementDepartment.setHasFixedSize(true);
                    placementDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list4, UpdateFaculty.this,"Placement Cell");
                    placementDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void examDepartment() {
        dbRef = reference.child("Exam Cell");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 =  new ArrayList<>();
                if(!dataSnapshot.exists()){
                    examNoData.setVisibility(View.VISIBLE);
                    examDepartment.setVisibility(View.GONE);

                }else{
                    examNoData.setVisibility(View.GONE);
                    examDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);

                    }
                    examDepartment.setHasFixedSize(true);
                    examDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list5, UpdateFaculty.this,"Exam Cell");
                    examDepartment.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}