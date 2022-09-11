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
        noticia1.setConteudoNoticia(getString(R.string.conteudo_noticia_1));
        noticia1.setAutor(R.string.gabriel_ass);
        noticia1.setDataDaPostagem(sdf.format(new Date()));
        noticia1.setImagem(R.drawable.noticia_cripto);
        noticia1.setTitulo(getString(R.string.titulo_noticia_1));
        noticias[0] = noticia1;

        NoticiaVo noticia2 = new NoticiaVo();
        noticia2.setConteudoNoticia(getString(R.string.conteudo_noticia_2));
        noticia2.setAutor(R.string.augusto_ass);
        noticia2.setDataDaPostagem(sdf.format(new Date()));
        noticia2.setImagem(R.drawable.noticia_formula_2);
        noticia2.setTitulo(getString(R.string.titulo_noticia_2));
        noticias[1] = noticia2;

        NoticiaVo noticia3 = new NoticiaVo();
        noticia3.setConteudoNoticia(getString(R.string.conteudo_noticia_3));
        noticia3.setAutor(R.string.gabriel_ass);
        noticia3.setDataDaPostagem(sdf.format(new Date()));
        noticia3.setImagem(R.drawable.noticia_guerra);
        noticia3.setTitulo(getString(R.string.titulo_noticia_3));
        noticias[2] = noticia3;

        NoticiaVo noticia4 = new NoticiaVo();
        noticia4.setConteudoNoticia(getString(R.string.conteudo_noticia_4));
        noticia4.setAutor(R.string.augusto_ass);
        noticia4.setDataDaPostagem(sdf.format(new Date()));
        noticia4.setImagem(R.drawable.noticia_antigua);
        noticia4.setTitulo(getString(R.string.titulo_noticia_4));
        noticias[3] = noticia4;

        NoticiaVo noticia5 = new NoticiaVo();
        noticia5.setConteudoNoticia(getString(R.string.conteudo_noticia_5));
        noticia5.setAutor(R.string.gabriel_ass);
        noticia5.setDataDaPostagem(sdf.format(new Date()));
        noticia5.setImagem(R.drawable.noticia_petra);
        noticia5.setTitulo(getString(R.string.titulo_noticia_5));
        noticias[4] = noticia5;

        definirPrimeiraNoticia();
    }

    private void definirPrimeiraNoticia() {
        noticiaDaVez = noticias[0];
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
        TextView indiceText = findViewById(R.id.indice_noticia);
        ImageView imagem = findViewById(R.id.imagem);

        autorText.setText(noticiaDaVez.getAutor());
        dataText.setText(noticiaDaVez.getDataDaPostagem());
        conteudoText.setText(noticiaDaVez.getConteudoNoticia());
        tituloText.setText(noticiaDaVez.getTitulo());
        indiceText.setText(Integer.toString(indiceNoticia + 1));
        imagem.setImageResource(noticiaDaVez.getImagem());

    }

}