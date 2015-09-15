package py.una.pol.motg.objects;

import java.util.ArrayList;
import java.util.List;


public class SustrateNetwork {
	private List<SustrateNode> listaNodos;
	public enum TypeNetwork{
		USNET,
		NSFNET
	}
	
	TypeNetwork tipo;
	
	public SustrateNetwork (){
		this.listaNodos = new ArrayList<SustrateNode>();
	}
	
	public SustrateNetwork (TypeNetwork tipo){
		this.tipo = tipo;
		generateSustrateNetwork();
	}

	public List<SustrateNode> getListaNodos() {
		return listaNodos;
	}
	

	public void setListaNodos(List<SustrateNode> listaNodos) {
		this.listaNodos = listaNodos;
	}

	public TypeNetwork getTipo() {
		return tipo;
	}

	public void setTipo(TypeNetwork tipo) {
		this.tipo = tipo;
	}
	
	/***
	 * Metodo que genera la red fisica en base al tipo seleccionado
	 */
	private void generateSustrateNetwork(){
		//tenemos una red NSF
		if (this.tipo.equals(TypeNetwork.USNET)){
			SustrateNode nodoA = new SustrateNode(0, 100);
			this.listaNodos.add(nodoA);
			SustrateNode nodoB = new SustrateNode(1, 100);
			this.listaNodos.add(nodoB);
			SustrateNode nodoC = new SustrateNode(2, 150);
			this.listaNodos.add(nodoC);
			SustrateNode nodoD = new SustrateNode(3, 170);
			this.listaNodos.add(nodoD);
			SustrateNode nodoE = new SustrateNode( 4, 200);
			this.listaNodos.add(nodoE);
			SustrateNode nodoF = new SustrateNode(5, 140); 
			this.listaNodos.add(nodoF);
			SustrateNode nodoG = new SustrateNode(6, 0);
			this.listaNodos.add(nodoG);
			SustrateNode nodoH = new SustrateNode(7, 210);
			this.listaNodos.add(nodoH);
			SustrateNode nodoI = new SustrateNode(8, 120);
			this.listaNodos.add(nodoI);
			SustrateNode nodoJ = new SustrateNode(9, 125); 
			this.listaNodos.add(nodoJ);
			SustrateNode nodoK = new SustrateNode(10, 180);
			this.listaNodos.add(nodoK);
			SustrateNode nodoL = new SustrateNode(11, 110);
			this.listaNodos.add(nodoL);
			SustrateNode nodoM = new SustrateNode(12, 145);
			this.listaNodos.add(nodoM);
			SustrateNode nodoN = new SustrateNode(13, 190);
			this.listaNodos.add(nodoN);
			SustrateNode nodoO = new SustrateNode(14, 230);
			this.listaNodos.add(nodoO);
			SustrateNode nodoP = new SustrateNode(15, 0);
			this.listaNodos.add(nodoP);
			SustrateNode nodoQ = new SustrateNode(16, 200);
			this.listaNodos.add(nodoQ);
			SustrateNode nodoR = new SustrateNode(17, 100); 
			this.listaNodos.add(nodoR);
			SustrateNode nodoS = new SustrateNode(18, 160);
			this.listaNodos.add(nodoS);
			SustrateNode nodoT = new SustrateNode(19, 0);
			this.listaNodos.add(nodoT);
			SustrateNode nodoU = new SustrateNode(20, 250);
			this.listaNodos.add(nodoU);
			SustrateNode nodoV = new SustrateNode(21, 110);
			this.listaNodos.add(nodoV);
			SustrateNode nodoW = new SustrateNode(22, 130);
			this.listaNodos.add(nodoW);
			SustrateNode nodoX = new SustrateNode(23, 240);
			this.listaNodos.add(nodoX);
			
			//Generamos los enlaces del Nodo A (1)
			SustrateLink linkAB = new SustrateLink(nodoB, 80);
			SustrateLink linkAF = new SustrateLink(nodoF, 100); 
			nodoA.addLink(linkAB);
			nodoA.addLink(linkAF);
			//Generamos los enlaces del nodo B(2)
			SustrateLink enlaceBA = new SustrateLink(nodoA, 80);
			nodoB.addLink(enlaceBA);
			SustrateLink enlaceBC = new SustrateLink(nodoC,110);
			nodoB.addLink(enlaceBC);
			SustrateLink enlaceBF = new SustrateLink(nodoF, 95);
			nodoB.addLink(enlaceBF);
			

			// enlaces del nodo C
			SustrateLink enlaceCB = new SustrateLink(nodoB,110);
			nodoC.addLink(enlaceCB);
			SustrateLink enlaceCE = new SustrateLink(nodoE, 108);
			nodoC.addLink(enlaceCE);
			SustrateLink enlaceCG = new SustrateLink(nodoG, 110);
			nodoC.addLink(enlaceCG);
			SustrateLink enlaceCD = new SustrateLink(nodoD, 25);
			nodoC.addLink(enlaceCD);

			// enlaces del nodo D
			SustrateLink enlaceDC = new SustrateLink(nodoC,25);
			nodoD.addLink(enlaceDC);
			SustrateLink enlaceDE = new SustrateLink(nodoE, 80);
			nodoD.addLink(enlaceDE);
			SustrateLink enlaceDF = new SustrateLink(nodoF, 85);
			nodoD.addLink(enlaceDF);
			
			// enlaces del nodo E
			SustrateLink enlaceED = new SustrateLink(nodoD, 80);
			nodoE.addLink(enlaceED);
			SustrateLink enlaceEC = new SustrateLink(nodoC,108);
			nodoE.addLink(enlaceEC);
			SustrateLink enlaceEH = new SustrateLink(nodoH,120);
			nodoE.addLink(enlaceEH);

			// enlaces del nodo F
			SustrateLink enlaceFA = new SustrateLink(nodoA,100);
			nodoF.addLink(enlaceFA);
			SustrateLink enlaceFB = new SustrateLink(nodoB, 95);
			nodoF.addLink(enlaceFB);
			SustrateLink enlaceFG = new SustrateLink(nodoG,180);
			nodoF.addLink(enlaceFG);
			SustrateLink enlaceFI = new SustrateLink(nodoI,120);
			nodoF.addLink(enlaceFI);
			SustrateLink enlaceFK = new SustrateLink(nodoK,190);
			nodoF.addLink(enlaceFK);

			// enlaces del nodo G
			SustrateLink enlaceGC = new SustrateLink(nodoC,100);
			nodoG.addLink(enlaceGC);
			SustrateLink enlaceGF = new SustrateLink(nodoF,180);
			nodoG.addLink(enlaceGF);
			SustrateLink enlaceGI = new SustrateLink(nodoI,100);
			nodoG.addLink(enlaceGI);
			SustrateLink enlaceGD = new SustrateLink(nodoD,100);
			nodoG.addLink(enlaceGD);
			SustrateLink enlaceGH = new SustrateLink(nodoH,85);
			nodoG.addLink(enlaceGH);

			// enlaces del nodo H
			SustrateLink enlaceHE = new SustrateLink(nodoE,150);
			nodoH.addLink(enlaceHE);
			SustrateLink enlaceHG = new SustrateLink(nodoG,115);
			nodoH.addLink(enlaceHG);
			SustrateLink enlaceHI = new SustrateLink(nodoI,90);
			nodoH.addLink(enlaceHI);

			// enlaces del nodo I
			SustrateLink enlaceIF = new SustrateLink(nodoF,120);
			nodoI.addLink(enlaceIF);
			SustrateLink enlaceIG = new SustrateLink(nodoG,100);
			nodoI.addLink(enlaceIG);
			SustrateLink enlaceIJ = new SustrateLink(nodoJ,115);
			nodoI.addLink(enlaceIJ);
			SustrateLink enlaceIL = new SustrateLink(nodoL,100);
			nodoI.addLink(enlaceIL);
			SustrateLink enlaceIk = new SustrateLink(nodoK,140);
			nodoI.addLink(enlaceIk);

			// enlaces del nodo J
			SustrateLink enlaceJH = new SustrateLink(nodoH,90);
			nodoJ.addLink(enlaceJH);
			SustrateLink enlaceJI = new SustrateLink(nodoI,100);
			nodoJ.addLink(enlaceJI);
			SustrateLink enlaceJM = new SustrateLink(nodoM,95);
			nodoJ.addLink(enlaceJM);
			SustrateLink enlaceJN = new SustrateLink(nodoN,85);
			nodoJ.addLink(enlaceJN);

			// enlaces del nodo K
			SustrateLink enlaceKF = new SustrateLink(nodoF,190);
			nodoK.addLink(enlaceKF);
			SustrateLink enlaceKI = new SustrateLink(nodoI,140);
			nodoK.addLink(enlaceKI);
			SustrateLink enlaceKL = new SustrateLink(nodoL,90);
			nodoK.addLink(enlaceKL);
			SustrateLink enlaceKO = new SustrateLink(nodoO,130);
			nodoK.addLink(enlaceKO);
			SustrateLink enlaceKS = new SustrateLink(nodoS,260);
			nodoK.addLink(enlaceKS);

			// enlaces del nodo L
			SustrateLink enlaceLI = new SustrateLink(nodoI,100);
			nodoL.addLink(enlaceLI);
			SustrateLink enlaceLK = new SustrateLink(nodoK,90);
			nodoL.addLink(enlaceLK);
			SustrateLink enlaceLM = new SustrateLink(nodoM,90);
			nodoL.addLink(enlaceLM);
			SustrateLink enlaceLP = new SustrateLink(nodoP,100);
			nodoL.addLink(enlaceLP);
			
			// enlaces del nodo M
			SustrateLink enlaceMN = new SustrateLink(nodoN,65);
			nodoM.addLink(enlaceMN);
			SustrateLink enlaceML = new SustrateLink(nodoL,90);
			nodoM.addLink(enlaceML);
			SustrateLink enlaceMQ = new SustrateLink(nodoQ,110);
			nodoM.addLink(enlaceMQ);
			SustrateLink enlaceMJ = new SustrateLink(nodoJ,95);
			nodoM.addLink(enlaceMJ);
			
			// enlaces del nodo N
			SustrateLink enlaceNM = new SustrateLink(nodoM,65);
			nodoN.addLink(enlaceNM);
			SustrateLink enlaceNJ = new SustrateLink(nodoJ,85);
			nodoN.addLink(enlaceNJ);
			SustrateLink enlaceNR = new SustrateLink(nodoR,120);
			nodoN.addLink(enlaceNR);

			// enlaces del nodo O
			SustrateLink enlaceOK = new SustrateLink(nodoK,130);
			nodoO.addLink(enlaceOK);
			SustrateLink enlaceOT = new SustrateLink(nodoT,130);
			nodoO.addLink(enlaceOT);
			SustrateLink enlaceOP = new SustrateLink(nodoP,60);
			nodoO.addLink(enlaceOP);
			
			// enlaces del nodo P
			SustrateLink enlacePL = new SustrateLink(nodoL,60);
			nodoP.addLink(enlacePL);
			SustrateLink enlacePO = new SustrateLink(nodoO,100);
			nodoP.addLink(enlacePO);
			SustrateLink enlacePQ = new SustrateLink(nodoQ,100);
			nodoP.addLink(enlacePQ);
			SustrateLink enlacePU = new SustrateLink(nodoU,100);
			nodoP.addLink(enlacePU);
			SustrateLink enlacePV = new SustrateLink(nodoV,80);
			nodoP.addLink(enlacePV);

			// enlaces del nodo Q
			SustrateLink enlaceQP = new SustrateLink(nodoP,100);
			nodoQ.addLink(enlaceQP);
			SustrateLink enlaceQM = new SustrateLink(nodoM,110);
			nodoQ.addLink(enlaceQM);
			SustrateLink enlaceQR = new SustrateLink(nodoR,80);
			nodoQ.addLink(enlaceQR);
			SustrateLink enlaceQV = new SustrateLink(nodoV,86);
			nodoQ.addLink(enlaceQV);
			SustrateLink enlaceQW = new SustrateLink(nodoW,100);
			nodoQ.addLink(enlaceQW);
			
			// enlaces del nodo R
			SustrateLink enlaceRQ = new SustrateLink(nodoQ,80);
			nodoR.addLink(enlaceRQ);
			SustrateLink enlaceRN = new SustrateLink(nodoN,120);
			nodoR.addLink(enlaceRN);
			SustrateLink enlaceRX = new SustrateLink(nodoX,90);
			nodoR.addLink(enlaceRX);
			
			// enlaces del nodo S
			SustrateLink enlaceSK = new SustrateLink(nodoK,30);
			nodoS.addLink(enlaceSK);
			SustrateLink enlaceST = new SustrateLink(nodoT,50);
			nodoS.addLink(enlaceST);
			
			// enlaces del nodo T
			SustrateLink enlaceTS = new SustrateLink(nodoS,120);
			nodoT.addLink(enlaceTS);
			SustrateLink enlaceTO = new SustrateLink(nodoO,130);
			nodoT.addLink(enlaceTO);
			SustrateLink enlaceTU = new SustrateLink(nodoU,70);
			nodoT.addLink(enlaceTU);
			
			// enlaces del nodo U
			SustrateLink enlaceUT = new SustrateLink(nodoT,70);
			nodoU.addLink(enlaceUT);
			SustrateLink enlaceUP = new SustrateLink(nodoP,100);
			nodoU.addLink(enlaceUP);
			SustrateLink enlaceUV = new SustrateLink(nodoV,30);
			nodoU.addLink(enlaceUV);
			
			// enlaces del nodo v
			SustrateLink enlaceVU = new SustrateLink(nodoU,30);
			nodoV.addLink(enlaceVU);
			SustrateLink enlaceVP = new SustrateLink(nodoP,80);
			nodoV.addLink(enlaceVP);
			SustrateLink enlaceVQ = new SustrateLink(nodoQ,85);
			nodoV.addLink(enlaceVQ);
			SustrateLink enlaceVW = new SustrateLink(nodoW,60);
			nodoV.addLink(enlaceVW);
			
			// enlaces del nodo W
			SustrateLink enlaceWV = new SustrateLink(nodoV,60);
			nodoW.addLink(enlaceWV);
			SustrateLink enlaceWQ = new SustrateLink(nodoQ,100);
			nodoW.addLink(enlaceWQ);
			SustrateLink enlaceWX = new SustrateLink(nodoX,90);
			nodoW.addLink(enlaceWX);
			
			// enlaces del nodo X
			SustrateLink enlaceXW = new SustrateLink(nodoW,90);
			nodoX.addLink(enlaceXW);
			SustrateLink enlaceXR = new SustrateLink(nodoR,90);
			nodoX.addLink(enlaceXR);	
			
		}
	}
	
}
	
	
