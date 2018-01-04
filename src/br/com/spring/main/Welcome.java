package br.com.spring.main;

import java.io.IOException;
import java.util.Locale;

import javax.swing.JOptionPane;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.SynthesizingMethodParameter;


public class Welcome {

	public static void main(String[] args) {
		ApplicationContext apContext = new ClassPathXmlApplicationContext(
				"/br/com/spring/config/ApplicationContext.xml");

		MessageSource ms = (MessageSource) apContext.getBean("messageSource");
		
		
		String bemvindo_padrao_sistema = ms.getMessage("mensagem.bemvindo",null,null);
		String bemvindo_us = ms.getMessage("mensagem.bemvindo",null,Locale.US);
		System.out.println(bemvindo_padrao_sistema);  // padrao do sistema.
		System.out.println(bemvindo_us);  // padrao do sistema.
		
		//Tambem pode forçar os sistema com um Locale padrão.
		Locale.setDefault(Locale.US);
		bemvindo_padrao_sistema = ms.getMessage("mensagem.bemvindo",null,null); // pega a propriedade novamente com Locale null.
		System.out.println(bemvindo_padrao_sistema);  // padrao do sistema agora US.
	}

}
