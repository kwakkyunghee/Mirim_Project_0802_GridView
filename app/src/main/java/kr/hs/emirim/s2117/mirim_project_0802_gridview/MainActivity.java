package kr.hs.emirim.s2117.mirim_project_0802_gridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    GridView gridv;
    int[] posterId = {R.drawable.dudrnjs, R.drawable.dlfrnjs,R.drawable.dlrnjs,R.drawable.tkarnjs,R.drawable.tkrnjs,R.drawable.dhrnjs,R.drawable.clfrnjs,R.drawable.vkfrnjs,R.drawable.rnrnjs,R.drawable.tlqtkrnjs,
            R.drawable.dudrnjs, R.drawable.dlfrnjs,R.drawable.dlrnjs,R.drawable.tkarnjs,R.drawable.tkrnjs,R.drawable.dhrnjs,R.drawable.clfrnjs,R.drawable.vkfrnjs,R.drawable.rnrnjs, R.drawable.tlqtkrnjs,
            R.drawable.dudrnjs, R.drawable.dlfrnjs,R.drawable.dlrnjs,R.drawable.tkarnjs,R.drawable.tkrnjs,R.drawable.dhrnjs,R.drawable.clfrnjs,R.drawable.vkfrnjs,R.drawable.rnrnjs,R.drawable.tlqtkrnjs};
    String[] posterTitle = {"주술회전 0", "주술회전 1", "주술회전 2", "주술회전 3", "주술회전 4", "주술회전 5", "주술회전 7", "주술회전 8", "주술회전 9", "주술회전 14",
            "주술회전 0", "주술회전 1", "주술회전 2", "주술회전 3", "주술회전 4", "주술회전 5", "주술회전 7", "주술회전 8", "주술회전 9", "주술회전 14",
            "주술회전 0", "주술회전 1", "주술회전 2", "주술회전 3", "주술회전 4", "주술회전 5", "주술회전 7", "주술회전 8", "주술회전 9", "주술회전 14"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("만화포스터(주술회전)");
        gridv = findViewById(R.id.gridv);
        PosterAdapter adapter = new PosterAdapter(this);
        gridv.setAdapter(adapter);
    }
    public class PosterAdapter extends BaseAdapter{//내부클래스/BaseAdapter추상클래스
            Context context;
            public PosterAdapter(Context context){
                this.context = context;//this.을 붙여야 필드 전역변수가됨
            }

        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imgv = new ImageView(context);
            GridView.LayoutParams params = new GridView.LayoutParams(200, 300); //ViewGroup GridView 둘다 가능 자식이기때문에
            imgv.setLayoutParams(params);
            imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgv.setPadding(5, 5, 5, 5);
            imgv.setImageResource(posterId[i]);
            final int pos = i;
            imgv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle(posterTitle[pos]);
                    dlg.setIcon(R.drawable.movie);

                    View dlgView = View.inflate(MainActivity.this, R.layout.dialog, null);
                    ImageView imgvDlg = dlgView.findViewById(R.id.imgv_dlg);
                    imgvDlg.setImageResource(posterId[pos]);
                    dlg.setView(dlgView);
                    dlg.setNegativeButton("close", null);
                    dlg.show();
                }
            });

            return imgv;
        }
    }
}