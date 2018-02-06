
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Frases {
	List<String> frases = new ArrayList<>();
	
	public Frases(){
		preencher();
	}
	
	
	public void preencher(){
		frases.add("A vida insiste em me surpreender, só queria que ela me surpreendesse com uma mala de dinheiro");
		frases.add("Nesse calor recomenda-se ligar o chuveiro no quente, provavelmente será mais fresco que a natural.");
		frases.add("Antes de ontem eu visitei seu perfil 3.000 vezes, ontem eu visitei 2875 vezes, e hoje eu visitei 2450 vezes. Cuidado! Você tá me perdendo aos poucos.");
		frases.add("Amiga, acabei de terminar um namoro de 2 anos. Nossa, e como você está? Estou bem, nem era meu.");
		frases.add("A justiça virou pó, e Aécio respirou aliviado.");
		frases.add("Eu até gosto de tu, mas prefiro lasanha.");
		frases.add("Foi traído e quer se matar, ameaçou se jogar dá sacada, não custa nada lembrar, isso é chifre não é asa.");
		frases.add("Quais são suas intenções comigo? Vender teu rim pra comprar um celular novo, por quê?");
		frases.add("Deveria existir um curso técnico pra a gente aprender a conduzir uma conversa depois do 'hum'.");
		frases.add("Sou um homem muito desejado pelas mulheres: Tem mulher que deseja me dar uma surra, tem mulher que deseja me dar um tapa, tem mulher que deseja me dar um tiro.");
		frases.add("Minha ex-namorada disse que sou muito infantil. Infantil é quem chama lá lá lá lá lá!");
		frases.add("Onde fica esse baile que todo mundo fica mandando seguir?");
		frases.add("Os bêbados, as crianças e as leggings sempre te falam a verdade!");
		frases.add("Depois da tempestade sempre vem a lembrança das roupas esquecidas no varal.");
		frases.add("Fui ao banco pedir empréstimo para investir no agronegócio, e me mandaram ir plantar batatas.");
		frases.add("Detesto o trabalho domestico! A gente arruma a cama, lava a louça, varre a casa, e dai a seis meses tem que fazer tudo de novo.");
		frases.add("Meu amor, você se acha um bom partido, inteira então deve ser maravilhosa.");
		frases.add("De tanto vai e volta, de tanto entra e sai, muito em breve, acredite, eu vou ser papai.");
		frases.add("Se car é carro em inglês, e men é homem, então minha tia Carmen é um transformes?");
		frases.add("Ontem dormi muito tarde e sonhei que casei. Hoje vou dormir mais cedo pra ir tratar do divórcio.");
		frases.add("Falou que queria conversar comigo, mas era Hinode.");
		frases.add("Sou o empurrãozinho da desculpa que você procurava.");
	}
	public String getAFrase(){
		Random r = new Random();
		return (frases.get(r.nextInt(frases.size())));
		
	}
}
