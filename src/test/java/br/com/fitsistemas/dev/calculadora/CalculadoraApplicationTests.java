package br.com.fitsistemas.dev.calculadora;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CalculadoraApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void verificarMetodoSoma() throws Exception {
		String jsonString = "{\"num1\" : \"123\",\"num2\" : \"22\"}";
		this.mockMvc.perform(post("/fazerSomaDeDoisNumeros/")
				.header("login", "suka ")
				.header("senha","123")
				.content(jsonString).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print());
	}
}

