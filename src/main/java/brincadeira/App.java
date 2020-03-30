package brincadeira;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class App {

	public static int qtdePessoas = 0;
	public static int qtdePerguntas = 0;
	public static String caminhoPlanilha = "";
	
	public static void main(String[] args) {
		
		InformationScreen informationScreen = new InformationScreen();
		informationScreen.setVisible(true);
		
		ArrayList<LinkedHashMap<String, String>> carregarPerguntas = new ArrayList<LinkedHashMap<String,String>>();
		for(int index = 0; index < qtdePessoas; index++) {
			LinkedHashMap<String, String> content = getSheetValues("a", "B1", index);
			if(content != null)
				carregarPerguntas.add(content);
		}
		
		ArrayList<Integer> ordemPerguntas = new ArrayList<Integer>();
		
		for(int i = 1; i <= (qtdePerguntas*qtdePerguntas); i++)
			ordemPerguntas.add(i);
		
		Random gerador = new Random();
		
		Collections.shuffle(ordemPerguntas);
		
		for(int i = 0; i < gerador.nextInt()+2; i++)
			Collections.shuffle(ordemPerguntas);
		
		LinkedHashMap<Integer, LinkedHashMap<String,String>> perguntas = new LinkedHashMap<Integer, LinkedHashMap<String,String>>();
		
		int index = 0;
		
		for(LinkedHashMap<String, String> valor : carregarPerguntas) {
			
			boolean firstvalue = false;
			String id = "";
			
			
			for (Map.Entry<String, String> entry : valor.entrySet()) {
				
				
				
				if(!firstvalue) {
					id = entry.getValue();
					firstvalue = true;
					continue;
				}
				
				LinkedHashMap<String,String> auxiliar = new LinkedHashMap<String,String>();
				
				auxiliar.put(id, entry.getKey() + " " +entry.getValue());
				perguntas.put(ordemPerguntas.get(index), auxiliar);
				index++;
				
			}
			
		}
		
		
		GameScreen screen = new GameScreen(perguntas);
		screen.setVisible(true);

	}
	
	@SuppressWarnings("resource")
	private static LinkedHashMap<String, String> getSheetValues(String sheetName, String cellReferenceName, int nextCol){
		
		LinkedHashMap<String, String> sheetMap = new LinkedHashMap<String, String>();
		
		Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(caminhoPlanilha);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		Sheet sheet = workbook.getSheet(sheetName);
		FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
		DataFormatter formatter = new DataFormatter();

		CellReference cellReference = new CellReference(cellReferenceName); 
		
		int cellRow = cellReference.getRow();
		int cellCol = cellReference.getCol();
		boolean firstValue = true;
		
		Row row = sheet.getRow(cellRow);
		Cell cell = null;
		
		
		while ((cell = row.getCell(cellCol)) != null) {
			
			//header
//			CellValue cellValue = evaluator.evaluate(cell);
			String valueHeader = formatter.formatCellValue(cell, evaluator);
			
			// value
			Row rowContent = sheet.getRow(cellRow+1+nextCol);
			Cell cellContent = rowContent.getCell(cellCol);
//			CellValue cellValueContent = evaluator.evaluate(cellContent);
//			DataFormatter formatter = new DataFormatter();
			String valueContent = "";
			try {
				valueContent = formatter.formatCellValue(cellContent, evaluator);
			} catch (Exception e) {
			}
			
			if(firstValue) {
				if(valueContent.equals(""))
					return null;
				
				firstValue = false;
			}
			
			sheetMap.put(valueHeader, valueContent);
			
			cellCol++;
		}
		
		if(workbook != null) {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		
		return sheetMap;
		
	}

}
