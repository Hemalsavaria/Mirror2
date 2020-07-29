package com.e.mirror.Model;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.e.mirror.R;

public class GenericTextWatcher implements TextWatcher
 {private View view;
     public GenericTextWatcher(View view)
     {
         this.view = view;
     }

     @Override
     public void afterTextChanged(Editable editable) {
         // TODO Auto-generated method stub
         String text = editable.toString();
         switch(view.getId())
         {

             case R.id.otp1:
                 if(text.length()==1)
                     view.requestFocus();
                 break;
             case R.id.otp2:
                 if(text.length()==1)
                     view.requestFocus();
                 else if(text.length()==0)
                     view.requestFocus();
                 break;
             case R.id.otp3:
                 if(text.length()==1)
                     view.requestFocus();
                 else if(text.length()==0)
                     view.requestFocus();
                 break;
             case R.id.otp4:
                 if(text.length()==0)
                     view.requestFocus();
                 break;
         }
     }

     @Override
     public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
         // TODO Auto-generated method stub
     }

     @Override
     public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
         // TODO Auto-generated method stub
     }
 }
