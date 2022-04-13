package com.bruneli.academia.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.bruneli.academia.converter.mocks.MockAluno;
import com.bruneli.academia.data.entities.Aluno;
import com.bruneli.academia.data.vo.AlunoVO;

public class DozerConverterTest {

	static MockAluno inputObject;
	
	@BeforeAll
	static void setUp() {
		inputObject = new MockAluno();
	}

	@Test
	public void parseEntityToVOTest() {
		AlunoVO output = DozerConverter.parseObject(inputObject.mockEntity(), AlunoVO.class);
		assertEquals(Long.valueOf(0L), output.getId());
		assertEquals("Bairro 0", output.getBairro());
		assertEquals("CPF 0", output.getCpf());
		assertEquals("Nome 0", output.getNome());
		assertEquals(LocalDate.now(), output.getDataNascimento());
	}

	@Test
	public void parseEntityListToVOListTest() {
		List<AlunoVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), AlunoVO.class);
		AlunoVO outputZERO = outputList.get(0);

		assertEquals(Long.valueOf(0L), outputZERO.getId());
		assertEquals("Bairro 0", outputZERO.getBairro());
		assertEquals("CPF 0", outputZERO.getCpf());
		assertEquals("Nome 0", outputZERO.getNome());
		assertEquals(LocalDate.now(), outputZERO.getDataNascimento());

		AlunoVO outputFIVE = outputList.get(5);

		assertEquals(Long.valueOf(5L), outputFIVE.getId());
		assertEquals("Bairro 5", outputFIVE.getBairro());
		assertEquals("CPF 5", outputFIVE.getCpf());
		assertEquals("Nome 5", outputFIVE.getNome());
		assertEquals(LocalDate.now().plusDays(5L), outputFIVE.getDataNascimento());
		
		AlunoVO outputTHIRTEEN = outputList.get(13);

		assertEquals(Long.valueOf(13L), outputTHIRTEEN.getId());
		assertEquals("Bairro 13", outputTHIRTEEN.getBairro());
		assertEquals("CPF 13", outputTHIRTEEN.getCpf());
		assertEquals("Nome 13", outputTHIRTEEN.getNome());
		assertEquals(LocalDate.now().plusDays(13L), outputTHIRTEEN.getDataNascimento());
	}
	
	@Test		
	public void parseVOToEntityTest() {
		Aluno output = DozerConverter.parseObject(inputObject.mockVO(), Aluno.class);
		assertEquals(Long.valueOf(0L), output.getId());
		assertEquals("Bairro 0", output.getBairro());
		assertEquals("CPF 0", output.getCpf());
		assertEquals("Nome 0", output.getNome());
	}
	
	@Test
	public void parseVOListToEntityListTest() {
		List<Aluno> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Aluno.class);
		Aluno outputZERO = outputList.get(0);

		assertEquals(Long.valueOf(0L), outputZERO.getId());
		assertEquals("Bairro 0", outputZERO.getBairro());
		assertEquals("CPF 0", outputZERO.getCpf());
		assertEquals("Nome 0", outputZERO.getNome());
		assertEquals(LocalDate.now().plusDays(0L), outputZERO.getDataNascimento());

		Aluno outputFIVE = outputList.get(5);

		assertEquals(Long.valueOf(5L), outputFIVE.getId());
		assertEquals("Bairro 5", outputFIVE.getBairro());
		assertEquals("CPF 5", outputFIVE.getCpf());
		assertEquals("Nome 5", outputFIVE.getNome());
		assertEquals(LocalDate.now().plusDays(5L), outputFIVE.getDataNascimento());
		
		Aluno outputTHIRTEEN = outputList.get(13);

		assertEquals(Long.valueOf(13L), outputTHIRTEEN.getId());
		assertEquals("Bairro 13", outputTHIRTEEN.getBairro());
		assertEquals("CPF 13", outputTHIRTEEN.getCpf());
		assertEquals("Nome 13", outputTHIRTEEN.getNome());
		assertEquals(LocalDate.now().plusDays(13L), outputTHIRTEEN.getDataNascimento());
	}

}
