package dicionario;

import java.util.HashMap;

/**
 * Created by amaraujo on 09/06/2016.
 */
public class Dicionario {

    private static Dicionario instance;
    private HashMap<String, String> dicionario = new HashMap<String, String>();


    private Dicionario(){

        dicionario.put("disseminação", "s.f. Ação ou efeito de disseminar ou disseminar-se.");
        dicionario.put("revogado", "adj. Anulado; que se anulou; que se tornou inválido ou sem efeito.");
        dicionario.put("remeter", "v.bit. Fazer com que alguma coisa chegue a certo local; enviar, mandar: " +
                "remeter uma correspondência à mãe.");
        dicionario.put("insensato", "adj. Que não possui bom senso; que se opõe à razão: sujeito insensato.");
        dicionario.put("vertente", "adj. Linha; divisão menor de um movimento cujos participantes defendem " +
                "pontos de vista próprios: seguia a vertente capitalista.");
        dicionario.put("atrás", "adv.Localizado na parte de trás; na parte posterior de: o carro tem um adesivo atrás");
        dicionario.put("renunciar", "v.t.d. e v.t.i. Negar ou recusar algo ou alguma coisa; rejeitar: " +
                "renunciar os prazeres da carne; renunciar à corrupção.");
        dicionario.put("deixar", "v.t.d. Retirar-se para o exterior de algo; sair: deixou o apartamento.");
        dicionario.put("escusa", "s.f. Ação de apresentar desculpas, de se desculpar ou de se justificar por; " +
                "desculpa: o juiz decidirá sobre o pedido de escusa.");
        dicionario.put("transeunte", "adj. Que é passageiro; que não perdura; de caráter transitório; transitivo: " +
                "estilo de vida transeunte.");
        dicionario.put("misógino", "s.m. Indivíduo que sente repulsa ou aversão às mulheres; " +
                "quem tem repulsão pelo contato sexual com mulheres; pessoa que sofre de misoginia.");
    }

    public static synchronized Dicionario getInstance(){
        if (instance == null){
            instance = new Dicionario();
        }
        return instance;
    }

    public HashMap<String, String> getDicionario() {
        return dicionario;
    }
}
