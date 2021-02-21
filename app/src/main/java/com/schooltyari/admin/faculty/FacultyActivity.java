package com.schooltyari.admin.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.schooltyari.admin.R;
import com.schooltyari.admin.TeacherAdapter;

import java.util.ArrayList;
import java.util.List;

public class FacultyActivity extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView englishDepart, mathDepart, physicsDepartment, chemistryDepartment,biologyDepartment,
            computerDepartment,physicalDepartment,hindiDepartment;
    private LinearLayout engNoData, mathNoData, physicsNoData, chemistryNoData,bioNoData,
            computrNoData,physicalNoData,hindiNoData;
    private List<TeacherData> list1, list2, list3, list4;
    private TeacherAdapter adapter;

    private DatabaseReference reference, dbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        englishDepart = findViewById(R.id.csDepartment);
        mathDepart = findViewById(R.id.mechanicalDepartment);
        physicsDepartment = findViewById(R.id.physicsDepartment);
        chemistryDepartment = findViewById(R.id.chemistryDepartment);
        biologyDepartment = findViewById(R.id.biologyDepartment);
        computerDepartment = findViewById(R.id.computerDepartment);
        physicalDepartment = findViewById(R.id.physicalDepartment);
        hindiDepartment = findViewById(R.id.hindiDepartment);


        engNoData = findViewById(R.id.csNoData);
        mathNoData = findViewById(R.id.mechNoData);
        physicsNoData = findViewById(R.id.physicsNoData);
        chemistryNoData = findViewById(R.id.chemistryNoData);
        bioNoData = findViewById(R.id.biologyNoData);
        computrNoData = findViewById(R.id.computerNoData);
        physicalNoData = findViewById(R.id.physicalNoData);
        hindiNoData = findViewById(R.id.hindiNoData);


        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        englishDepartment();
        mathDepartment();
        physicsDepartment();
        chemistryDepartment();
        biologyDepartment();
        computerDepartment();
        physicalDepartment();
        hindiDepartment();


        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FacultyActivity.this, AddTeacherActivity.class));
            }
        });

    }

    private void englishDepartment () {
        dbRef = reference.child("English");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    engNoData.setVisibility(View.VISIBLE);
                    englishDepart.setVisibility(View.GONE);
                } else {
                    engNoData.setVisibility(View.GONE);
                    englishDepart.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    englishDepart
                            .setHasFixedSize(true);
                    englishDepart.setLayoutManager(new LinearLayoutManager(FacultyActivity.this));
                    adapter = new TeacherAdapter(list1, FacultyActivity.this, "English");
                    englishDepart.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(FacultyActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mathDepartment () {
        dbRef = reference.child("Math");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    mathNoData.setVisibility(View.VISIBLE);
                    mathDepart.setVisibility(View.GONE);
                } else {
                    mathNoData.setVisibility(View.GONE);
                    mathDepart.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    mathDepart.setHasFixedSize(true);
                    mathDepart.setLayoutManager(new LinearLayoutManager(FacultyActivity.this));
                    adapter = new TeacherAdapter(list2, FacultyActivity.this, "Math");
                    mathDepart.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(FacultyActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void physicsDepartment () {
        dbRef = reference.child("Physics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    physicsNoData.setVisibility(View.VISIBLE);
                    physicsDepartment.setVisibility(View.GONE);
                } else {
                    physicsNoData.setVisibility(View.GONE);
                    physicsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    physicsDepartment.setHasFixedSize(true);
                    physicsDepartment.setLayoutManager(new LinearLayoutManager(FacultyActivity.this));
                    adapter = new TeacherAdapter(list3, FacultyActivity.this, "Physics");
                    physicsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(FacultyActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void chemistryDepartment () {
        dbRef = reference.child("Chemistry");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    chemistryNoData.setVisibility(View.VISIBLE);
                    chemistryDepartment.setVisibility(View.GONE);
                } else {
                    chemistryNoData.setVisibility(View.GONE);
                    chemistryDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    chemistryDepartment.setHasFixedSize(true);
                    chemistryDepartment.setLayoutManager(new LinearLayoutManager(FacultyActivity.this));
                    adapter = new TeacherAdapter(list4, FacultyActivity.this, "Chemistry");
                    chemistryDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(FacultyActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void biologyDepartment () {
        dbRef = reference.child("Biology");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    bioNoData.setVisibility(View.VISIBLE);
                    biologyDepartment.setVisibility(View.GONE);
                } else {
                    bioNoData.setVisibility(View.GONE);
                    biologyDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    biologyDepartment.setHasFixedSize(true);
                    biologyDepartment.setLayoutManager(new LinearLayoutManager(FacultyActivity.this));
                    adapter = new TeacherAdapter(list4, FacultyActivity.this, "Biology");
                    biologyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(FacultyActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void computerDepartment () {
        dbRef = reference.child("Computer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    computrNoData.setVisibility(View.VISIBLE);
                    computerDepartment.setVisibility(View.GONE);
                } else {
                    computrNoData.setVisibility(View.GONE);
                    computerDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    computerDepartment.setHasFixedSize(true);
                    computerDepartment.setLayoutManager(new LinearLayoutManager(FacultyActivity.this));
                    adapter = new TeacherAdapter(list4, FacultyActivity.this, "Computer");
                    computerDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(FacultyActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void physicalDepartment () {
        dbRef = reference.child("Physical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    physicalNoData.setVisibility(View.VISIBLE);
                    physicalDepartment.setVisibility(View.GONE);
                } else {
                    physicalNoData.setVisibility(View.GONE);
                    physicalDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    physicalDepartment.setHasFixedSize(true);
                    physicalDepartment.setLayoutManager(new LinearLayoutManager(FacultyActivity.this));
                    adapter = new TeacherAdapter(list4, FacultyActivity.this, "Physical");
                    physicalDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(FacultyActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void hindiDepartment () {
        dbRef = reference.child("Hindi");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    hindiNoData.setVisibility(View.VISIBLE);
                    hindiDepartment.setVisibility(View.GONE);
                } else {
                    hindiNoData.setVisibility(View.GONE);
                    hindiDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    hindiDepartment.setHasFixedSize(true);
                    hindiDepartment.setLayoutManager(new LinearLayoutManager(FacultyActivity.this));
                    adapter = new TeacherAdapter(list4, FacultyActivity.this, "Hindi");
                    hindiDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(FacultyActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        }
    }
