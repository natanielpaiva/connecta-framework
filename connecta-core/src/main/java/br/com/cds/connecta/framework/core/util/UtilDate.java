package br.com.cds.connecta.framework.core.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * 
 * @author Ryan Achilles de Thuin
 * @version 0.1
 */
public class UtilDate {
	private static final int MILLIS_DIA = 86400000;
	public static final int DIA = 1;
	public static final int MES = 2;
	public static final int ANO = 3;
	private static final Locale locale = new Locale("pt", "BR");
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
	public static final String DATEFORMAT = "dd/MM/yyyy";
        public static final String DB_DATEFORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

	
	/**
	 *  
	 * @return java.util.Date
	 */
	public static java.util.Date getDataAtual() {
		return new Date();
	}
	
	/**
	 * 
	 * @param date
	 * @return java.util.Date
	 */
	public static Date getSqlDateComoDate(java.sql.Date date) {
		if (date != null) {
			return new Date(date.getTime());
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * @param date
	 * @return java.sql.Date
	 */
	public static java.sql.Date getDateComoSqlDate(Date date) {
		if (date != null) {
			return new java.sql.Date(date.getTime());
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * @param date
	 * @return java.sql.Timestamp
	 */
	public static java.sql.Timestamp getDateComoSqlTimestamp(Date date) {
		if (date != null) {
			return new java.sql.Timestamp(date.getTime());
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * @param date
	 * @return java.sql.Time
	 */
	public static java.sql.Time getDateComoSqlTime(Date date) {
		if (date != null) {
			return new java.sql.Time(date.getTime());
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * @param data
	 * @return String
	 */
	public static String getDataComoString(Date data) {
		return formatDate(data, "dd/MM/yyyy");
	}
	
	
	public static String getDataHoraMilesimo(Date data) {
		return formatDate(data, "yyyy-MM-dd HH:mm:ss.SSS");
	}
	
	
	/**
	 * 
	 * @param data
	 * @return String
	 */
	public static String getHoraComoString(Date data) {
		return formatDate(data, "HH:mm");
	}
	
	/**
	 * 
	 * @param data
	 * @return String
	 */
	public static String getHoraMinSegComoString(Date data) {
		return formatDate(data, "HH:mm:ss");
	}
	
	/**
	 * 
	 * @param data
	 * @return String
	 */
	public static String getDataHoraComoString(Date data) {
		return formatDate(data, "dd/MM/yyyy hh:mm:ss");
	}
	
	/**
	 * 
	 * @param date
	 * @return String
	 */
	public static String getDataInvertidaComoString(Date date) {
		return formatDate(date, "yyyy-MM-dd");
	}
	
	/**
	 * 
	 * @param data
	 * @param formatoDaData
	 * @return String
	 */
	public static String formatDate(Date data, String formatoDaData) {
		if (data == null) {
			return "";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatoDaData,
				locale);
		return dateFormat.format(data);
	}
	
	/**
	 * 
	 * @param dataString
	 * @param dateFormat
	 * @return Date
	 * @throws ParseException
	 */
	public static Date getData(String dataString, String dateFormat)
			throws ParseException {
                if(Util.isEmpty(dataString)){
                    return null;
                }
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat,
				locale);
		simpleDateFormat.setLenient(false);
		return sdf.parse(dataString);
	}
	
	/**
	 * 
	 * @param dataString
	 * @return Date
	 * @throws ParseException
	 */
	public static Date getData(String dataString) throws ParseException {
		return getData(dataString, "dd/MM/yyyy");
	}
	
	/**
	 * 
	 * @param dataHoraString
	 * @return Date
	 * @throws ParseException
	 */
	public static Date getDataHora(String dataHoraString) throws ParseException {
		return getData(dataHoraString, "dd/MM/yyyy hh:mm:ss");
	}
	
	public static Date getDataHoraMilesimo(String dataHoraString) throws ParseException {
		return getData(dataHoraString, "yyyy-MM-dd HH:mm:ss.SSS");
	}
	
	/**
	 * 
	 * @param ano
	 * @param mes
	 * @param dia
	 * @param hora
	 * @param minuto
	 * @param segundo
	 * @return Date
	 */
	public static Date novaData(int ano, int mes, int dia, int hora,
			int minuto, int segundo) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(ano, mes, dia, hora, minuto, segundo);
		return calendar.getTime();
	}

	
	/**
	 * 
	 * @param date
	 * @return Date
	 */
	public static Date getHoraZero(Date date) {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(date);
		int residuoDeMilisegundos = calendario.get(Calendar.MILLISECOND);
		int residuoDeSegundos = calendario.get(Calendar.SECOND) * 1000;
		int residuoDeMinutos = calendario.get(Calendar.MINUTE) * 60000;
		int residuoDeHoras = calendario.get(Calendar.HOUR_OF_DAY) * 3600000;
		int residuoTotal = residuoDeMilisegundos + residuoDeSegundos
				+ residuoDeMinutos + residuoDeHoras;
		long longDate = calendario.getTimeInMillis() - residuoTotal;
		return new Date(longDate);
	}
	
	/**
	 * 
	 * @param millis
	 * @return int
	 */
	public static int millisToDias(long millis) {
		return (int) (millis / MILLIS_DIA);
	}
	
	
	/**
	 * 
	 * @param quantidadeDeDias
	 * @return long
	 */
	public static long diasToMillis(int quantidadeDeDias) {
		return quantidadeDeDias * MILLIS_DIA;
	}
	
	/**
	 * 
	 * @param quantidadeDeHoras
	 * @return long
	 */
	public static long horasToMillis(int quantidadeDeHoras) {
		return quantidadeDeHoras * MILLIS_DIA;
	}
	
	/**
	 * 
	 * @param quantidadeDeMinutos
	 * @return long
	 */
	public static long minutosToMillis(int quantidadeDeMinutos) {
		return quantidadeDeMinutos * 60000;
	}

	public static long segundosToMillis(int quantidadeDeSegundos) {
		return quantidadeDeSegundos * 1000;
	}

	public static Date somaHoras(Date data, int quantidadeDeHoras) {
		return somaCampo(Calendar.HOUR_OF_DAY, data, quantidadeDeHoras);
	}

	public static Date somaMinutos(Date data, int quantidadeDeMinutos) {
		return somaCampo(Calendar.MINUTE, data, quantidadeDeMinutos);
	}

	public static Date somaMilisegundos(Date data, int quantidadeDeMilisegundos) {
		return somaCampo(Calendar.MILLISECOND, data, quantidadeDeMilisegundos);
	}

	public static Date somaSegundos(Date data, int quantidadeDeSegundos) {
		return somaCampo(Calendar.SECOND, data, quantidadeDeSegundos);
	}

	public static Date somaDias(Date data, int quantidadeDeDias) {
		return somaCampo(Calendar.DAY_OF_MONTH, data, quantidadeDeDias);
	}

	public static Date somaMeses(Date data, int numeroDeMeses) {
		return somaCampo(Calendar.MONTH, data, numeroDeMeses);
	}

	public static Date somaAnos(Date data, int numeroDeAnos) {
		return somaCampo(Calendar.YEAR, data, numeroDeAnos);
	}

	public static Date somaCampo(int campo, Date data, int quantidade) {
		Calendar calendar = getCalendarDaData(data);
		calendar.add(campo, quantidade);
		return calendar.getTime();
	}

	public static int diferencaEmAnos(Date dataA, Date dataB) {
		return (UtilDate.getAno(dataA) - UtilDate.getAno(dataB));
	}

	public static int diferencaEmMeses(Date dataA, Date dataB) {
		int anoA = UtilDate.getAno(dataA);
		int anoB = UtilDate.getAno(dataB);
		int mesA = UtilDate.getMes(dataA);
		int mesB = UtilDate.getMes(dataB);
		if (dataA.before(dataB)) {
			return ((anoB - anoA) * 12 + (mesB - mesA)) * -1;
		} else {
			return (anoA - anoB) * 12 + (mesA - mesB);
		}
	}

	public static int diferencaEmDias(Date dataA, Date dataB) {
		int diferencaTemporaria = 0;
		int diferencaEmDias = 0;
		Calendar menorData = Calendar.getInstance();
		Calendar maiorData = Calendar.getInstance();
		if (dataA.compareTo(dataB) < 0) {
			menorData.setTime(dataA);
			maiorData.setTime(dataB);
		} else {
			menorData.setTime(dataB);
			maiorData.setTime(dataA);
		}
		while (menorData.get(Calendar.YEAR) != maiorData.get(Calendar.YEAR)) {
			diferencaTemporaria = 365 * (maiorData.get(Calendar.YEAR) - menorData
					.get(Calendar.YEAR));
			diferencaEmDias += diferencaTemporaria;
			menorData.add(Calendar.DAY_OF_YEAR, diferencaTemporaria);
		}
		if (menorData.get(Calendar.DAY_OF_YEAR) != maiorData
				.get(Calendar.DAY_OF_YEAR)) {
			diferencaTemporaria = maiorData.get(Calendar.DAY_OF_YEAR)
					- menorData.get(Calendar.DAY_OF_YEAR);
			diferencaEmDias += diferencaTemporaria;
			menorData.add(Calendar.DAY_OF_YEAR, diferencaTemporaria);
		}
		return diferencaEmDias;
	}

	public static Date getPrimeiroDoMesAtual() {
		return getCalendarPrimeiroDoMesAtual().getTime();
	}

	public static Calendar getCalendarPrimeiroDoMesAtual() {
		Calendar calendar = getCalendarDeHoje();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return zeraCalendar(calendar);
	}

	public static Calendar getCalendarDeHoje() {
		return getCalendarDaData(new Date());
	}

	public static Calendar getCalendarDeHojeHoraZero() {
		Calendar calendar = getCalendarDeHoje();
		return zeraCalendar(calendar);
	}

	public static Calendar zeraCalendar(Calendar calendar) {
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar;
	}

	public static Calendar getCalendarDaData(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		return calendar;
	}

	public static Date subtraiDias(Date date, int quantidadeDeDias) {
		return somaDias(date, -quantidadeDeDias);
	}

	public static int getUltimoDiaDoMes(Date data) {
		Calendar calendar = getCalendarDaData(data);
		return calendar.getActualMaximum(Calendar.DATE);
	}

	/**
	 * 
	 * @param data
	 * 
	 * @return -1 caso o parametro data esteja nulo
	 */
	public static int getAno(Date data) {
		if (data == null) {
			return -1;
		}

		String ano = formatDate(data, "yyyy");
		return Integer.parseInt(ano);
	}

	public static int getAnoAtual() {
		return getAno(getDataAtual());
	}

	public static int getMes(Date data) {
		String mes = formatDate(data, "MM");
		return Integer.parseInt(mes);
	}

	public static int getDia(Date data) {
		String dia = formatDate(data, "dd");
		return Integer.parseInt(dia);
	}

	public static int getHoras(Date data) {
		String dia = formatDate(data, "HH");
		return Integer.parseInt(dia);
	}

	public static int getMinutos(Date data) {
		String dia = formatDate(data, "mm");
		return Integer.parseInt(dia);
	}

	public static int getSegundos(Date data) {
		String dia = formatDate(data, "ss");
		return Integer.parseInt(dia);
	}

	/**
	 * @param data
	 * @return 1 = domingo, 7 = s�bado
	 */
	public static int getDiaDaSemana(Date data) {
		return getCalendarDaData(data).get(Calendar.DAY_OF_WEEK);
	}

	public static boolean isMesmoDia(Date dataA, Date dataB) {
		if (dataA != null && dataB != null) {
			Calendar a = Calendar.getInstance();
			a.setTime(dataA);
			Calendar b = Calendar.getInstance();
			b.setTime(dataB);
			return (a.get(Calendar.YEAR) == b.get(Calendar.YEAR)
					&& a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a
					.get(Calendar.DATE) == b.get(Calendar.DATE));
		} else {
			return false;
		}
	}

	public static boolean isDataNaFaixa(Date data, Date dataInicial,
			Date dataFinal) {
		return (dataInicial == null || data.compareTo(dataInicial) >= 0)
				&& (dataFinal == null || data.compareTo(dataFinal) <= 0);
	}

	public static boolean isDataValida(String data) {
		return isDataValida(data, "dd/MM/yyyy");
	}

	public static boolean isDataValida(String data, String formatoDaData) {
		try {
			StringTokenizer tokenizer = new StringTokenizer(data, "/");
			int ano, mes, dia;
			dia = Integer.parseInt(tokenizer.nextToken());
			mes = Integer.parseInt(tokenizer.nextToken());
			ano = Integer.parseInt(tokenizer.nextToken());
			Calendar calendario = new GregorianCalendar();
			SimpleDateFormat formatador = new SimpleDateFormat(formatoDaData);
			java.util.Date resposta = formatador.parse(data);
			calendario.setTime(resposta);
			return (ano == calendario.get(Calendar.YEAR)
					&& mes == calendario.get(Calendar.MONTH) + 1 && dia == calendario
					.get(Calendar.DATE));
		} catch (Exception e) {
			return false;
		}
	}

	public static Date setDiaDaData(Date data, int dia) {
		Calendar calendar = getCalendarDaData(data);
		try {
			calendar.set(Calendar.DAY_OF_MONTH, dia);
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
		return calendar.getTime();
	}

	public static Date setMesDaData(Date data, int mes) {
		Calendar calendar = getCalendarDaData(data);
		try {
			calendar.set(Calendar.MONTH, mes - 1);
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
		return calendar.getTime();
	}

	public static Date setAnoDaData(Date data, int ano) {
		Calendar calendar = getCalendarDaData(data);
		try {
			calendar.set(Calendar.YEAR, ano);
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
		return calendar.getTime();
	}

	
	public static String getDataPorExtenso(Date data) {
		String o[] = { "de", "de" };
		MessageFormat msg = new MessageFormat(formatDate(data,
				"dd {0} MMMMM {1} yyyy"));
		return msg.format(o);
	}

	public static Date getDataNoUltimoDiaDoMes(Date data) {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(data);
		calendario.set(Calendar.DAY_OF_MONTH, calendario
				.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendario.getTime();
	}

	public static String getMesLiteral(int mes) {
		Date data = null;
		try {
			data = getData("01/01/1970");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		data = setMesDaData(data, mes);
		return formatDate(data, "MMMMM");
	}

	public static Time getDateComoTime(Date value) {
		Time time = null;
		if (value != null) {
			time = new Time(value.getTime());
		}
		return time;
	}

	public static int getDiaMaximoDoMes(Date data) {
		Calendar calendar = getCalendarDaData(data);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * @param data
	 * @return
	 */
	public static boolean isHoraRedunda(Date data) {
		return getMinutos(data) == 0;
	}

	/**
	 * @param fim
	 * @param inicio
	 * @return
	 */
	public static long diferencaEmMinutos(Date fim, Date inicio) {
		return (fim.getTime() - inicio.getTime()) / 60000;
	}

	/**
	 * 
	 * @param dataSelecionada
	 * @return
	 */
	public static Date getDataPrimeiroDiaMesDepois(Date dataSelecionada) {
		return somaDias(getDataNoUltimoDiaDoMes(dataSelecionada), 1);
	}

	public static Date getDateComHoraFinal(Date date) {
		return novaData(getAno(date), getMes(date) - 1, getDia(date), 23, 59,
				59);
	}

	/**
	 * Compara datas desprezando a hora
	 * 
	 * @param data1
	 * @param data2
	 * @return valor booleano indicando se os dias informados o mesmo
	 */
	public static boolean equalsDia(Date data1, Date data2) {
		return diferencaEmDias(data1, data2) == 0;
	}

	public static Date juntaTime(Date data, Date horas) {
		Calendar calendar = getCalendarDaData(data);
		calendar.set(Calendar.HOUR_OF_DAY, UtilDate.getHoras(horas));
		calendar.set(Calendar.MINUTE, UtilDate.getMinutos(horas));
		calendar.set(Calendar.SECOND, UtilDate.getSegundos(horas));
		return calendar.getTime();
	}

	public static String getDiaDaSemanaLiteral(Date data) {
		return formatDate(data, "EEEEEEEEEEEEE");
	}

	public static Date getDataAtualSeNula(Date data) {
		Date resposta = data;
		if (data == null) {
			resposta = getDataAtual();
		}
		return resposta;
	}

	public static Date getDateDoTimestamp(Timestamp timestamp) {
		Date resposta = null;
		if (timestamp != null) {
			resposta = new Date(timestamp.getTime());
		}
		return resposta;
	}

	public static String getDataSubtraida(Date dataFinal) {
		Date dataAtual = Calendar.getInstance().getTime();
		Date dataInicialDoJava = novaData(1970, 0, 1, 0, 0, 0);
		long periodo = dataAtual.getTime() - dataFinal.getTime();
		int dia = getDia(new Date(periodo - dataInicialDoJava.getTime())) - 1;
		int mes = getMes(new Date(periodo - dataInicialDoJava.getTime()));
		int ano = getAno(new Date(periodo - dataInicialDoJava.getTime())) - 70;
		return " " + dia + " dias " + mes + " mes(es)" + ano + " anos";
	}

	public static int getHoraMinutosSegundosEmSegundos(Date data) {
		int numeroDeSegundos = getHoras(data) * 3600;
		numeroDeSegundos += getMinutos(data) * 60;
		numeroDeSegundos += getSegundos(data);
		return numeroDeSegundos;
	}

	public static int getIdadeEmAnos(Date dataDeNascimento) {
		return getIdadeEmAnos(dataDeNascimento, getDataAtual());
	}
	
	public static String converteData(Date dataAtual) {
		SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfOutput = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date date = sdfInput.parse(dataAtual.toString());
			return sdfOutput.format(date);
		} catch (ParseException Ex) {
			return "Erro na conversão da data";
		}
	}

	public static int getIdadeEmAnos(Date dataDeNascimento,
			Date dataDeReferencia) {
		int diferencaEmAnos = getAno(dataDeReferencia)
				- getAno(dataDeNascimento);
		int diferencaEmMeses = getMes(dataDeReferencia)
				- getMes(dataDeNascimento);
		int diferencaEmDias = getDia(dataDeReferencia)
				- getDia(dataDeNascimento);
		if (diferencaEmAnos <= 0) {
			return 0;
		} else if (diferencaEmMeses < 0
				|| (diferencaEmMeses == 0 && diferencaEmDias < 0)) {
			return diferencaEmAnos - 1;
		}
		return diferencaEmAnos;
	}

}
