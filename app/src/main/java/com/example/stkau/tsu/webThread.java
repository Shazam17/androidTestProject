package com.example.stkau.tsu;

import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Text;

import java.io.IOException;

public class webThread extends Thread {

    private Document doc;
    private String grNmb;
    private Lesson[][] lesRef;


    public webThread(Document d , String grNmb, Lesson[][] ref ){
       this.doc = d;
       this.grNmb = grNmb;
       this.lesRef = ref;
    }

    @Override
    public void run() {

        try {
            doc = Jsoup.connect("https://timetable.tusur.ru/faculties/fsu/groups/" + grNmb).get();

        }catch (IOException exception){

        }

        parseTimeT();


       // for(int i = 0 ; i < 7 ; i++){
        //    String txt = web.getText().toString();
      //      web.setText(txt + '\n' + lesRef[0][i].getName());
       // }

    }
    private void  parseTimeT(){

        for (int i = 0; i < 6; i++) {
            int jIter = 0;

            for (Element a : doc.select(".table").first().select(".day_" + Integer.toString(i + 1))) {
                Elements sel = a.select(".training");

                if(!sel.isEmpty()){
                    lesRef[i][jIter] = new Lesson(sel.select(".discipline").text(), sel.select(".kind").text(), sel.select(".auditoriums").text(), sel.select(".group").text());
                }
                jIter++;
            }
        }

    }

}
