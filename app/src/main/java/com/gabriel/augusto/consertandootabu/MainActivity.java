package com.gabriel.augusto.consertandootabu;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.gabriel.augusto.consertandootabu.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private NoticiaVo noticia1;

    private NoticiaVo noticia2;

    private NoticiaVo noticia3;

    private NoticiaVo noticia4;

    private NoticiaVo noticia5;

    private NoticiaVo[] noticias;

    private static int indiceNoticia = 0;

    private static NoticiaVo noticiaDaVez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        noticias = new NoticiaVo[5];

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        NoticiaVo noticia1 = new NoticiaVo();
        noticia1.setConteudoNoticia("Todavia, a expansão dos mercados mundiais maximiza as possibilidades por conta do retorno esperado a longo prazo.");
        noticia1.setAutor(R.string.gabriel_ass);
        noticia1.setDataDaPostagem(sdf.format(new Date()));
        noticia1.setImagem(R.drawable.bolsonaro_come_pombo);
        noticia1.setTitulo("Valha meu Deus");
        noticias[0] = noticia1;

        NoticiaVo noticia2 = new NoticiaVo();
        noticia2.setConteudoNoticia("Todas estas questões, devidamente ponderadas, levantam dúvidas sobre se a mobilidade dos capitais internacionais deve passar por modificações independentemente do fluxo de informações.");
        noticia2.setAutor(R.string.gabriel_ass);
        noticia2.setDataDaPostagem(sdf.format(new Date()));
        noticia2.setImagem(R.drawable.dilma_come_pombo);
        noticia2.setTitulo("Valha meu Jesus");
        noticias[1] = noticia2;

        NoticiaVo noticia3 = new NoticiaVo();
        noticia3.setConteudoNoticia("Evidentemente, o início da atividade geral de formação de atitudes facilita a criação dos relacionamentos verticais entre as hierarquias.");
        noticia3.setAutor(R.string.gabriel_ass);
        noticia3.setDataDaPostagem(sdf.format(new Date()));
        noticia3.setImagem(R.drawable.bolsonaro_come_pombo);
        noticia3.setTitulo("Valha padin pade ciço");
        noticias[2] = noticia3;

        NoticiaVo noticia4 = new NoticiaVo();
        noticia4.setConteudoNoticia("Por conseguinte, o surgimento do comércio virtual exige a precisão e a definição dos métodos utilizados na avaliação de resultados.");
        noticia4.setAutor(R.string.gabriel_ass);
        noticia4.setDataDaPostagem(sdf.format(new Date()));
        noticia4.setImagem(R.drawable.dilma_come_pombo);
        noticia4.setTitulo("Crê em Deus pai");
        noticias[3] = noticia4;

        NoticiaVo noticia5 = new NoticiaVo();
        noticia5.setConteudoNoticia("É importante questionar o quanto a determinação clara de objetivos auxilia a preparação e a composição do impacto na agilidade decisória.");
        noticia5.setAutor(R.string.gabriel_ass);
        noticia5.setDataDaPostagem(sdf.format(new Date()));
        noticia5.setImagem(R.drawable.bolsonaro_come_pombo);
        noticia5.setTitulo("Chupingole");
        noticias[4] = noticia5;

    }

    public void proximaNoticia(View view) {
        indiceNoticia++;
        mudarNoticia(view);
    }

    public void noticiaAnterior(View view) {
        indiceNoticia--;
        mudarNoticia(view);
    }

    private void mudarNoticia(View view) {
        indiceNoticia = indiceNoticia <= -1 ? 4 : indiceNoticia >= 5 ? 0 : indiceNoticia;
        noticiaDaVez = noticias[indiceNoticia];
        TextView autorText = findViewById(R.id.autor_noticia);
        TextView dataText = findViewById(R.id.data_noticia);
        TextView conteudoText = findViewById(R.id.conteudo_noticia);
        TextView tituloText = findViewById(R.id.titulo_noticia);
        ImageView imagem = findViewById(R.id.imagem);

        autorText.setText(noticiaDaVez.getAutor());
        dataText.setText(noticiaDaVez.getDataDaPostagem());
        conteudoText.setText(noticiaDaVez.getConteudoNoticia());
        tituloText.setText(noticiaDaVez.getTitulo());
        imagem.setImageResource(noticiaDaVez.getImagem());
        System.out.println(indiceNoticia);
    }

}