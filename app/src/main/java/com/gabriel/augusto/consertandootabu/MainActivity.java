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
        noticia1.setConteudoNoticia("A Comissão de Valores Mobiliários do Brasil (CVM) informou que quer colaborar com o projeto de lei que vai regulamentar as criptomoedas no Brasil.\n" +
                "\n" +
                "De acordo com o presidente da CVM, João Pedro Nascimento, o objetivo do regulador é ajudar a aperfeiçoar o PL que atualmente está em tramitação na Câmara dos Deputados após a aprovação no Senado.\n" +
                "\n" +
                "João Pedro disse ainda que a ideia é que a regulação do setor seja “não invasiva”\n" +
                "\n" +
                "“Estamos trabalhando, sim, com uma regulação não invasiva e de braços dados com o Banco Central. Daremos uma contribuição para os projetos de lei que surgirem, esse inclusive que já está bem próximo de uma definição”, disse ele durante seminário promovido pela OAB (Ordem dos Advogados do Brasil), conforme noticiou o Valor Econômico.");
        noticia1.setAutor(R.string.gabriel_ass);
        noticia1.setDataDaPostagem(sdf.format(new Date()));
        noticia1.setImagem(R.drawable.noticia_cripto);
        noticia1.setTitulo("CVM quer contribuir com PL que vai regular criptomoedas no Brasil");
        noticias[0] = noticia1;

        NoticiaVo noticia2 = new NoticiaVo();
        noticia2.setConteudoNoticia("Histórico! A disputa não foi na pista, como todos imaginavam, mas o resultado veio: Felipe Drugovich é o primeiro campeão brasileiro da história da F2! O piloto da MP Motorsport abandonou logo na primeira volta após toque com Amaury Cordeel e, do pitlane, viu o rival Theo Pourchaire ter problemas em disputa com Liam Lawson.");
        noticia2.setAutor(R.string.augusto_ass);
        noticia2.setDataDaPostagem(sdf.format(new Date()));
        noticia2.setImagem(R.drawable.noticia_formula_2);
        noticia2.setTitulo("Piloto brasileiro campeão!");
        noticias[1] = noticia2;

        NoticiaVo noticia3 = new NoticiaVo();
        noticia3.setConteudoNoticia("Milhares de pessoas deixaram a região de Kharkiv, na Ucrânia, palco da contraofensiva de Kiev, para a Rússia em 24 horas, afirmou neste domingo o governador da região russa de Belgorod, que faz fronteira com a Ucrânia.\n" +
                "\n" +
                "\"Não foi a noite ou a manhã mais tranquila. Nas últimas 24 horas, milhares de pessoas cruzaram a fronteira\", disse Viacheslav Gladkov em um vídeo postado no Telegram. No início deste mês, o exército ucraniano anunciou pela primeira vez uma contraofensiva no sul, antes de fazer um avanço surpresa nesta semana contra as linhas russas no nordeste, na região de Kharkiv.");
        noticia3.setAutor(R.string.gabriel_ass);
        noticia3.setDataDaPostagem(sdf.format(new Date()));
        noticia3.setImagem(R.drawable.noticia_guerra);
        noticia3.setTitulo("Após ofensiva ucraniana, governador russo diz que 'milhares' de pessoas saíram de Kharkiv, na Ucrânia, e entraram na Rússia");
        noticias[2] = noticia3;

        NoticiaVo noticia4 = new NoticiaVo();
        noticia4.setConteudoNoticia("Antigua e Barbuda deve fazer um referendo sobre se tornar uma república após a morte da rainha Elizabeth 2ª, segundo afirmou o primeiro-ministro do país no domingo (11/09).\n" +
                "\n" +
                "Antigua e Barbuda é um dos 14 países, além do Reino Unido, que tem o monarca britânico, agora Charles 3º, como chefe de Estado. O primeiro-ministro Gaston Browne disse que um referendo pode acontecer nos próximos três anos, mas disse que isso \"não é um ato de hostilidade\".\n" +
                "\n" +
                "Ele fez o anúncio após cerimônia de confirmação de Charles 3º como chefe de Estado da nação caribenha.\n" +
                "\n" +
                "Browne disse que vai promover o referendo se for reeleito no ano que vem, o que é esperado, uma vez que seu partido comanda atualmente 15 dos 17 assentos do Parlamento.");
        noticia4.setAutor(R.string.augusto_ass);
        noticia4.setDataDaPostagem(sdf.format(new Date()));
        noticia4.setImagem(R.drawable.noticia_antigua);
        noticia4.setTitulo("Charles 3º: Antigua e Barbuda planeja referendo sobre manter rei como chefe de Estado");
        noticias[3] = noticia4;

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