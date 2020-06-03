package com.example.internshipmyemmo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.Collator;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class volleyresult extends AppCompatActivity {

    private Collator VolleySingleton;
    ArrayList<Employee> employeeArrayList;
    private Object Employee;
    TextView tt1,tt2,tt3,tt4,tt5;
    ScrollView ss;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volleyresult);
        tt1 = findViewById(R.id.tt1);
        tt2 = findViewById(R.id.tt2);
        tt3 = findViewById(R.id.tt3);
        tt4 = findViewById(R.id.tt4);
        tt5 = findViewById(R.id.tt5);

        ss= findViewById(R.id.ss);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Constants.ROOT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);

//                    Toast.makeText(volleyresult.this, ""+obj.get("status")+"--"+obj.getJSONArray(), Toast.LENGTH_SHORT).show();
                    String status = obj.getString("status");
                    JSONArray jsonArray = obj.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
//                        Toast.makeText(volleyresult.this, "--><--" + jsonObject.get("employee_name"), Toast.LENGTH_SHORT).show();
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

//id, String employee_name, String employee_salary, String employee_age, String profile_image
//                        Log.d("meinkarliya",""+jsonObject.getString("id"));
                        Employee employee = new Employee(jsonObject.get("id").toString(), jsonObject.getString("employee_name"), jsonObject.getString("employee_salary"), jsonObject.getString("employee_age"), jsonObject.getString("profile_image"));
                        employeeArrayList.add(employee);
                        tt1.setText(jsonObject.get("id").toString());
                        tt2.setText(jsonObject.getString("employee_name"));
                        tt3.setText(jsonObject.getString("employee_salary"));
                        tt4.setText(jsonObject.getString("employee_age"));
                        tt5.setText(jsonObject.getString("profile_image"));
                                ss.addView(tt1);
                        ss.addView(tt2);
                        ss.addView(tt3);
                        ss.addView(tt4);
                        ss.addView(tt5);

//                        }
                    }
//                    Data data =new Data(status,employeeArrayList);

//                    data.getArray()[0].id
//
//                            for(int j=0;j<data.getArray().size();j++){
//                                tt.setText(data.getArray().toString().);
//                                ss.addView(tt);
//                            }
//                     else {
//                        // Toast.makeText(Login.this, "Something Goes Wrong", Toast.LENGTH_SHORT).show();
//                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //     Toast.makeText(Login.this, "Something goes Wrong", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(volleyresult.this);
        requestQueue.add(stringRequest);

    }
}

