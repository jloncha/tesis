package py.una.pol.motg.ilp;
import ilog.concert.IloNumExpr;
import ilog.concert.IloNumVar;
import ilog.concert.IloObjective;
import ilog.cplex.IloCplex;

public class ILPSolver {
	
	public ILPSolver(){
	}
	
	public void instanciar(){
		try{
			IloCplex cplex = new IloCplex();
			IloNumVar x = cplex.numVar(0, 9999, "x");
			IloNumVar y = cplex.numVar(0, 9999, "y");
			IloNumExpr expr =cplex.sum(cplex.prod(0.12, x),cplex.prod(0.15, y));
			IloNumExpr rest1 =cplex.sum(cplex.prod(60, x),cplex.prod(60, y));
			IloNumExpr rest2 =cplex.sum(cplex.prod(12, x),cplex.prod(6, y));
			IloNumExpr rest3 =cplex.sum(cplex.prod(10, x),cplex.prod(30, y));
			cplex.addLe(300, rest1);
			cplex.addLe(36, rest2);
			cplex.addLe(90, rest3);
			IloObjective objetivo = cplex.minimize(expr);
			System.out.print(cplex.getObjValue());
			
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
			
}
