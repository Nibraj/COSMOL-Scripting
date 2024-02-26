/*
 * SlidingMode_2D.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Feb 13 2024, 15:27 by COMSOL 6.1.0.357. */
public class SlidingMode_2D {

  public static Model run() {
    Model model = ModelUtil.create("Model");

    model.modelPath("/Users/guest1/Desktop/Academics/Term 8/8000");

    model.component().create("comp1", true);

    model.component("comp1").geom().create("geom1", 2);

    model.component("comp1").mesh().create("mesh1");

    model.component("comp1").physics().create("es", "Electrostatics", "geom1");

    model.study().create("std1");
    model.study("std1").create("stat", "Stationary");
    model.study("std1").feature("stat").setSolveFor("/physics/es", true);

    model.component("comp1").geom("geom1").run();

    model.param().set("x1", "0.1[mm]");

    model.component("comp1").geom("geom1").lengthUnit("\u00b5in");
    model.component("comp1").geom("geom1").lengthUnit("mm");
    model.component("comp1").geom("geom1").run("fin");
    model.component("comp1").geom("geom1").run("");
    model.component("comp1").geom("geom1").create("r1", "Rectangle");
    model.component("comp1").geom("geom1").feature("r1").set("size", new double[]{100, 0.22});
    model.component("comp1").geom("geom1").feature("r1").set("pos", new int[]{-100, 0});
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").feature().duplicate("r2", "r1");
    model.component("comp1").geom("geom1").feature("r1").label("bottom");
    model.component("comp1").geom("geom1").feature("r2").label("top");
    model.component("comp1").geom("geom1").feature("r2").set("pos", new String[]{"-100+x1", "0.22"});
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").run("r2");
    model.component("comp1").geom("geom1").create("r3", "Rectangle");
    model.component("comp1").geom("geom1").feature("r3").set("size", new int[]{400, 200});
    model.component("comp1").geom("geom1").feature("r3").set("pos", new int[]{-200, -100});
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").feature("r3").setIndex("layer", 10, 0);
    model.component("comp1").geom("geom1").feature("r3").set("layerleft", true);
    model.component("comp1").geom("geom1").feature("r3").set("layerright", true);
    model.component("comp1").geom("geom1").feature("r3").set("layertop", true);
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").run("fin");

    model.component("comp1").coordSystem().create("ie1", "InfiniteElement");
    model.component("comp1").coordSystem().create("ie2", "InfiniteElement");
    model.component("comp1").coordSystem().create("ie3", "InfiniteElement");
    model.component("comp1").coordSystem("ie3").selection().set(1, 2, 3, 4, 6, 9, 10, 11);
    model.component("comp1").coordSystem().remove("ie2");
    model.component("comp1").coordSystem().remove("ie1");

    model.component("comp1").material().create("mat1", "Common");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("eta", "Piecewise");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("Cp", "Piecewise");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("rho", "Analytic");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("k", "Piecewise");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("cs", "Analytic");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("an1", "Analytic");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("an2", "Analytic");
    model.component("comp1").material("mat1").propertyGroup().create("RefractiveIndex", "Refractive index");
    model.component("comp1").material("mat1").propertyGroup().create("NonlinearModel", "Nonlinear model");
    model.component("comp1").material("mat1").propertyGroup().create("idealGas", "Ideal gas");
    model.component("comp1").material("mat1").propertyGroup("idealGas").func().create("Cp", "Piecewise");
    model.component("comp1").material("mat1").label("Air");
    model.component("comp1").material("mat1").set("family", "air");
    model.component("comp1").material("mat1").propertyGroup("def").func("eta").set("arg", "T");
    model.component("comp1").material("mat1").propertyGroup("def").func("eta")
         .set("pieces", new String[][]{{"200.0", "1600.0", "-8.38278E-7+8.35717342E-8*T^1-7.69429583E-11*T^2+4.6437266E-14*T^3-1.06585607E-17*T^4"}});
    model.component("comp1").material("mat1").propertyGroup("def").func("eta").set("argunit", "K");
    model.component("comp1").material("mat1").propertyGroup("def").func("eta").set("fununit", "Pa*s");
    model.component("comp1").material("mat1").propertyGroup("def").func("Cp").set("arg", "T");
    model.component("comp1").material("mat1").propertyGroup("def").func("Cp")
         .set("pieces", new String[][]{{"200.0", "1600.0", "1047.63657-0.372589265*T^1+9.45304214E-4*T^2-6.02409443E-7*T^3+1.2858961E-10*T^4"}});
    model.component("comp1").material("mat1").propertyGroup("def").func("Cp").set("argunit", "K");
    model.component("comp1").material("mat1").propertyGroup("def").func("Cp").set("fununit", "J/(kg*K)");
    model.component("comp1").material("mat1").propertyGroup("def").func("rho")
         .set("expr", "pA*0.02897/R_const[K*mol/J]/T");
    model.component("comp1").material("mat1").propertyGroup("def").func("rho").set("args", new String[]{"pA", "T"});
    model.component("comp1").material("mat1").propertyGroup("def").func("rho").set("fununit", "kg/m^3");
    model.component("comp1").material("mat1").propertyGroup("def").func("rho")
         .set("argunit", new String[]{"Pa", "K"});
    model.component("comp1").material("mat1").propertyGroup("def").func("rho")
         .set("plotargs", new String[][]{{"pA", "101325", "101325"}, {"T", "273.15", "293.15"}});
    model.component("comp1").material("mat1").propertyGroup("def").func("k").set("arg", "T");
    model.component("comp1").material("mat1").propertyGroup("def").func("k")
         .set("pieces", new String[][]{{"200.0", "1600.0", "-0.00227583562+1.15480022E-4*T^1-7.90252856E-8*T^2+4.11702505E-11*T^3-7.43864331E-15*T^4"}});
    model.component("comp1").material("mat1").propertyGroup("def").func("k").set("argunit", "K");
    model.component("comp1").material("mat1").propertyGroup("def").func("k").set("fununit", "W/(m*K)");
    model.component("comp1").material("mat1").propertyGroup("def").func("cs")
         .set("expr", "sqrt(1.4*R_const[K*mol/J]/0.02897*T)");
    model.component("comp1").material("mat1").propertyGroup("def").func("cs").set("args", new String[]{"T"});
    model.component("comp1").material("mat1").propertyGroup("def").func("cs").set("fununit", "m/s");
    model.component("comp1").material("mat1").propertyGroup("def").func("cs").set("argunit", new String[]{"K"});
    model.component("comp1").material("mat1").propertyGroup("def").func("cs")
         .set("plotargs", new String[][]{{"T", "273.15", "373.15"}});
    model.component("comp1").material("mat1").propertyGroup("def").func("an1").set("funcname", "alpha_p");
    model.component("comp1").material("mat1").propertyGroup("def").func("an1")
         .set("expr", "-1/rho(pA,T)*d(rho(pA,T),T)");
    model.component("comp1").material("mat1").propertyGroup("def").func("an1").set("args", new String[]{"pA", "T"});
    model.component("comp1").material("mat1").propertyGroup("def").func("an1").set("fununit", "1/K");
    model.component("comp1").material("mat1").propertyGroup("def").func("an1")
         .set("argunit", new String[]{"Pa", "K"});
    model.component("comp1").material("mat1").propertyGroup("def").func("an1")
         .set("plotargs", new String[][]{{"pA", "101325", "101325"}, {"T", "273.15", "373.15"}});
    model.component("comp1").material("mat1").propertyGroup("def").func("an2").set("funcname", "muB");
    model.component("comp1").material("mat1").propertyGroup("def").func("an2").set("expr", "0.6*eta(T)");
    model.component("comp1").material("mat1").propertyGroup("def").func("an2").set("args", new String[]{"T"});
    model.component("comp1").material("mat1").propertyGroup("def").func("an2").set("fununit", "Pa*s");
    model.component("comp1").material("mat1").propertyGroup("def").func("an2").set("argunit", new String[]{"K"});
    model.component("comp1").material("mat1").propertyGroup("def").func("an2")
         .set("plotargs", new String[][]{{"T", "200", "1600"}});
    model.component("comp1").material("mat1").propertyGroup("def").set("thermalexpansioncoefficient", "");
    model.component("comp1").material("mat1").propertyGroup("def").set("molarmass", "");
    model.component("comp1").material("mat1").propertyGroup("def").set("bulkviscosity", "");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("thermalexpansioncoefficient", new String[]{"alpha_p(pA,T)", "0", "0", "0", "alpha_p(pA,T)", "0", "0", "0", "alpha_p(pA,T)"});
    model.component("comp1").material("mat1").propertyGroup("def").set("molarmass", "0.02897[kg/mol]");
    model.component("comp1").material("mat1").propertyGroup("def").set("bulkviscosity", "muB(T)");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("relpermeability", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("relpermittivity", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat1").propertyGroup("def").set("dynamicviscosity", "eta(T)");
    model.component("comp1").material("mat1").propertyGroup("def").set("ratioofspecificheat", "1.4");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("electricconductivity", new String[]{"0[S/m]", "0", "0", "0", "0[S/m]", "0", "0", "0", "0[S/m]"});
    model.component("comp1").material("mat1").propertyGroup("def").set("heatcapacity", "Cp(T)");
    model.component("comp1").material("mat1").propertyGroup("def").set("density", "rho(pA,T)");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("thermalconductivity", new String[]{"k(T)", "0", "0", "0", "k(T)", "0", "0", "0", "k(T)"});
    model.component("comp1").material("mat1").propertyGroup("def").set("soundspeed", "cs(T)");
    model.component("comp1").material("mat1").propertyGroup("def").addInput("temperature");
    model.component("comp1").material("mat1").propertyGroup("def").addInput("pressure");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat1").propertyGroup("NonlinearModel").set("BA", "(def.gamma+1)/2");
    model.component("comp1").material("mat1").propertyGroup("idealGas").func("Cp").label("Piecewise 2");
    model.component("comp1").material("mat1").propertyGroup("idealGas").func("Cp").set("arg", "T");
    model.component("comp1").material("mat1").propertyGroup("idealGas").func("Cp")
         .set("pieces", new String[][]{{"200.0", "1600.0", "1047.63657-0.372589265*T^1+9.45304214E-4*T^2-6.02409443E-7*T^3+1.2858961E-10*T^4"}});
    model.component("comp1").material("mat1").propertyGroup("idealGas").func("Cp").set("argunit", "K");
    model.component("comp1").material("mat1").propertyGroup("idealGas").func("Cp").set("fununit", "J/(kg*K)");
    model.component("comp1").material("mat1").propertyGroup("idealGas").set("Rs", "R_const/Mn");
    model.component("comp1").material("mat1").propertyGroup("idealGas").set("heatcapacity", "Cp(T)");
    model.component("comp1").material("mat1").propertyGroup("idealGas").set("ratioofspecificheat", "1.4");
    model.component("comp1").material("mat1").propertyGroup("idealGas").set("molarmass", "0.02897");
    model.component("comp1").material("mat1").propertyGroup("idealGas").addInput("temperature");
    model.component("comp1").material("mat1").propertyGroup("idealGas").addInput("pressure");
    model.component("comp1").material("mat1").materialType("nonSolid");
    model.component("comp1").material("mat1").set("family", "air");
    model.component("comp1").material("mat1").selection().set(1, 2, 3, 4, 5, 6, 9, 10, 11);
    model.component("comp1").material().create("mat2", "Common");
    model.component("comp1").material("mat2").selection().set(7);
    model.component("comp1").material("mat2").propertyGroup("def").set("relpermittivity", new String[]{"2"});
    model.component("comp1").material("mat2").selection().set(7);
    model.component("comp1").material("mat2").label("bottom");
    model.component("comp1").material().duplicate("mat3", "mat2");
    model.component("comp1").material("mat3").selection().set(8);
    model.component("comp1").material("mat3").propertyGroup("def").set("relpermittivity", new String[]{"4"});
    model.component("comp1").material("mat3").label("top");

    model.component("comp1").physics("es").prop("d").set("d", 0.1);
    model.component("comp1").physics("es").create("gnd1", "Ground", 1);
    model.component("comp1").physics("es").feature("gnd1").selection().set(1, 2, 3, 5, 7, 9, 14, 25, 30, 31, 32, 33);
    model.component("comp1").physics("es").create("sfcd1", "SurfaceChargeDensity", 1);
    model.component("comp1").physics("es").feature("sfcd1").selection().set(17);
    model.component("comp1").physics("es").feature("sfcd1").set("rhoqs", "-7e-6");
    model.component("comp1").physics("es").create("sfcd2", "SurfaceChargeDensity", 1);
    model.component("comp1").physics("es").feature("sfcd2").selection().set(22);
    model.component("comp1").physics("es").feature("sfcd2").set("rhoqs", "7e-6");
    model.component("comp1").physics("es").create("fp1", "FloatingPotential", 1);
    model.component("comp1").physics("es").create("fp2", "FloatingPotential", 1);
    model.component("comp1").physics("es").feature("fp1").selection().set(20);
    model.component("comp1").physics("es").feature("fp2").selection().set(16);

    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").autoMeshSize(3);
    model.component("comp1").mesh("mesh1").autoMeshSize(1);
    model.component("comp1").mesh("mesh1").run();

    model.study("std1").feature("stat").set("useparam", false);
    model.study("std1").create("param", "Parametric");
    model.study("std1").feature("param").setIndex("pname", "x1", 0);
    model.study("std1").feature("param").setIndex("plistarr", "", 0);
    model.study("std1").feature("param").setIndex("punit", "m", 0);
    model.study("std1").feature("param").setIndex("pname", "x1", 0);
    model.study("std1").feature("param").setIndex("plistarr", "", 0);
    model.study("std1").feature("param").setIndex("punit", "m", 0);
    model.study("std1").feature("param").setIndex("plistarr", "range(0.1,2,100)", 0);
    model.study("std1").feature("param").setIndex("punit", "mm", 0);

    model.sol().create("sol1");
    model.sol("sol1").study("std1");

    model.study("std1").feature("stat").set("notlistsolnum", 1);
    model.study("std1").feature("stat").set("notsolnum", "auto");
    model.study("std1").feature("stat").set("listsolnum", 1);
    model.study("std1").feature("stat").set("solnum", "auto");

    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "stat");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "stat");
    model.sol("sol1").create("s1", "Stationary");
    model.sol("sol1").feature("s1").create("fc1", "FullyCoupled");
    model.sol("sol1").feature("s1").feature("fc1").set("linsolver", "dDef");
    model.sol("sol1").feature("s1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");

    model.batch().create("p1", "Parametric");
    model.batch("p1").study("std1");
    model.batch("p1").create("so1", "Solutionseq");
    model.batch("p1").feature("so1").set("seq", "sol1");
    model.batch("p1").feature("so1").set("store", "on");
    model.batch("p1").feature("so1").set("clear", "on");
    model.batch("p1").feature("so1").set("psol", "none");
    model.batch("p1").set("pname", new String[]{"x1"});
    model.batch("p1").set("plistarr", new String[]{"range(0.1,2,100)"});
    model.batch("p1").set("sweeptype", "sparse");
    model.batch("p1").set("probesel", "all");
    model.batch("p1").set("probes", new String[]{});
    model.batch("p1").set("plot", "off");
    model.batch("p1").set("err", "on");
    model.batch("p1").attach("std1");
    model.batch("p1").set("control", "param");

    model.sol().create("sol2");
    model.sol("sol2").study("std1");
    model.sol("sol2").label("Parametric Solutions 1");

    model.batch("p1").feature("so1").set("psol", "sol2");

    model.result().create("pg1", "PlotGroup2D");
    model.result("pg1").label("Electric Potential (es)");
    model.result("pg1").set("frametype", "spatial");
    model.result("pg1").set("showlegendsmaxmin", true);
    model.result("pg1").set("data", "dset2");
    model.result("pg1").set("defaultPlotID", "InterfaceComponents/PlotDefaults/icom2/pdef1/pcond2/pcond2/pg1");
    model.result("pg1").feature().create("surf1", "Surface");
    model.result("pg1").feature("surf1").set("showsolutionparams", "on");
    model.result("pg1").feature("surf1").set("solutionparams", "parent");
    model.result("pg1").feature("surf1").set("colortable", "Dipole");
    model.result("pg1").feature("surf1").set("showsolutionparams", "on");
    model.result("pg1").feature("surf1").set("data", "parent");
    model.result("pg1").feature().create("str1", "Streamline");
    model.result("pg1").feature("str1").set("showsolutionparams", "on");
    model.result("pg1").feature("str1").set("solutionparams", "parent");
    model.result("pg1").feature("str1").set("titletype", "none");
    model.result("pg1").feature("str1").set("posmethod", "uniform");
    model.result("pg1").feature("str1").set("udist", 0.02);
    model.result("pg1").feature("str1").set("maxlen", 0.4);
    model.result("pg1").feature("str1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("str1").set("inheritcolor", false);
    model.result("pg1").feature("str1").set("showsolutionparams", "on");
    model.result("pg1").feature("str1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("str1").set("showsolutionparams", "on");
    model.result("pg1").feature("str1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("str1").set("showsolutionparams", "on");
    model.result("pg1").feature("str1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("str1").set("showsolutionparams", "on");
    model.result("pg1").feature("str1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg1").feature("str1").set("data", "parent");
    model.result("pg1").feature("str1").set("inheritplot", "surf1");
    model.result("pg1").feature("str1").feature().create("col1", "Color");
    model.result("pg1").feature("str1").feature("col1").set("colortable", "DipoleDark");
    model.result("pg1").feature("str1").feature("col1").set("colorlegend", false);
    model.result("pg1").feature("str1").feature().create("filt1", "Filter");
    model.result("pg1").feature("str1").feature("filt1").set("expr", "!isScalingSystemDomain");
    model.result().create("pg2", "PlotGroup2D");
    model.result("pg2").label("Electric Field Norm (es)");
    model.result("pg2").set("frametype", "spatial");
    model.result("pg2").set("showlegendsmaxmin", true);
    model.result("pg2").set("data", "dset2");
    model.result("pg2").set("defaultPlotID", "InterfaceComponents/PlotDefaults/icom3/pdef1/pcond2/pcond2/pg1");
    model.result("pg2").feature().create("surf1", "Surface");
    model.result("pg2").feature("surf1").set("showsolutionparams", "on");
    model.result("pg2").feature("surf1").set("solutionparams", "parent");
    model.result("pg2").feature("surf1").set("expr", "es.normE");
    model.result("pg2").feature("surf1").set("colortable", "Prism");
    model.result("pg2").feature("surf1").set("colortabletrans", "nonlinear");
    model.result("pg2").feature("surf1").set("colorcalibration", -0.8);
    model.result("pg2").feature("surf1").set("showsolutionparams", "on");
    model.result("pg2").feature("surf1").set("data", "parent");
    model.result("pg2").feature().create("str1", "Streamline");
    model.result("pg2").feature("str1").set("showsolutionparams", "on");
    model.result("pg2").feature("str1").set("solutionparams", "parent");
    model.result("pg2").feature("str1").set("titletype", "none");
    model.result("pg2").feature("str1").set("posmethod", "uniform");
    model.result("pg2").feature("str1").set("udist", 0.02);
    model.result("pg2").feature("str1").set("maxlen", 0.4);
    model.result("pg2").feature("str1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg2").feature("str1").set("inheritcolor", false);
    model.result("pg2").feature("str1").set("showsolutionparams", "on");
    model.result("pg2").feature("str1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg2").feature("str1").set("showsolutionparams", "on");
    model.result("pg2").feature("str1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg2").feature("str1").set("showsolutionparams", "on");
    model.result("pg2").feature("str1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg2").feature("str1").set("showsolutionparams", "on");
    model.result("pg2").feature("str1").set("maxtime", Double.POSITIVE_INFINITY);
    model.result("pg2").feature("str1").set("data", "parent");
    model.result("pg2").feature("str1").set("inheritplot", "surf1");
    model.result("pg2").feature("str1").feature().create("col1", "Color");
    model.result("pg2").feature("str1").feature("col1").set("expr", "es.normE");
    model.result("pg2").feature("str1").feature("col1").set("colortable", "PrismDark");
    model.result("pg2").feature("str1").feature("col1").set("colorlegend", false);
    model.result("pg2").feature("str1").feature("col1").set("colortabletrans", "nonlinear");
    model.result("pg2").feature("str1").feature("col1").set("colorcalibration", -0.8);
    model.result("pg2").feature("str1").feature().create("filt1", "Filter");
    model.result("pg2").feature("str1").feature("filt1").set("expr", "!isScalingSystemDomain");

    model.batch("p1").run("compute");

    model.result("pg1").set("data", "dset2");
    model.result("pg1").feature("str1").selection().geom("geom1", 1);
    model.result("pg1").feature("str1").selection()
         .set(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33);
    model.result("pg2").set("data", "dset2");
    model.result("pg2").feature("str1").selection().geom("geom1", 1);
    model.result("pg2").feature("str1").selection()
         .set(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33);
    model.result("pg1").run();
    model.result("pg1").stepFirst(0);
    model.result("pg1").run();
    model.result("pg1").stepNext(0);
    model.result("pg1").run();
    model.result("pg1").stepNext(0);
    model.result("pg1").run();
    model.result("pg1").stepNext(0);
    model.result("pg1").run();
    model.result("pg1").stepNext(0);
    model.result("pg1").run();
    model.result("pg1").stepNext(0);
    model.result("pg1").run();
    model.result("pg1").stepNext(0);
    model.result("pg1").run();
    model.result("pg1").stepNext(0);
    model.result("pg1").run();
    model.result("pg1").stepNext(0);
    model.result("pg1").run();
    model.result("pg1").stepNext(0);
    model.result("pg1").run();
    model.result("pg1").stepNext(0);
    model.result("pg1").run();
    model.result("pg1").stepNext(0);
    model.result("pg1").run();
    model.result("pg1").stepNext(0);
    model.result("pg1").run();
    model.result("pg1").stepNext(0);
    model.result("pg1").run();
    model.result("pg1").stepNext(0);
    model.result("pg1").run();
    model.result("pg1").stepNext(0);
    model.result("pg1").run();
    model.result("pg1").stepNext(0);
    model.result("pg1").run();
    model.result("pg1").stepFirst(0);
    model.result("pg1").run();
    model.result("pg1").stepLast(0);
    model.result("pg1").run();

    model.label("SlidingMode_2D.mph");

    model.result("pg1").run();
    model.result().numerical().create("gev1", "EvalGlobal");
    model.result().numerical("gev1").set("expr", new String[]{"es.intWe"});
    model.result().numerical("gev1").set("descr", new String[]{"Total electric energy"});
    model.result().numerical("gev1").set("unit", new String[]{"J"});
    model.result().table().create("tbl1", "Table");
    model.result().table("tbl1").comments("Global Evaluation 1");
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();
    model.result().numerical("gev1").set("data", "dset2");
    model.result().table().create("tbl2", "Table");
    model.result().table("tbl2").comments("Global Evaluation 1");
    model.result().numerical("gev1").set("table", "tbl2");
    model.result().numerical("gev1").setResult();
    model.result().table("tbl2").save("C:\\Users\\mnazariansam\\Desktop\\TENGs\\COMSOL_YouTube\\SlidingMode_2D.csv");
    model.result().create("pg3", "PlotGroup1D");
    model.result("pg3").run();
    model.result("pg3").create("ptgr1", "PointGraph");
    model.result("pg3").feature("ptgr1").set("markerpos", "datapoints");
    model.result("pg3").feature("ptgr1").set("linewidth", "preference");
    model.result("pg3").feature().remove("ptgr1");
    model.result("pg3").run();
    model.result("pg3").create("glob1", "Global");
    model.result("pg3").feature("glob1").set("markerpos", "datapoints");
    model.result("pg3").feature("glob1").set("linewidth", "preference");
    model.result("pg3").feature("glob1").set("expr", new String[]{"es.intWe"});
    model.result("pg3").feature("glob1").set("descr", new String[]{"Total electric energy"});
    model.result("pg3").feature("glob1").set("unit", new String[]{"J"});
    model.result("pg3").run();
    model.result("pg3").feature("glob1").set("data", "dset2");
    model.result("pg3").run();
    model.result().numerical().create("av1", "AvLine");
    model.result().numerical("av1").set("intsurface", true);
    model.result().numerical("av1").selection().set(20);
    model.result().numerical("av1").set("expr", new String[]{"V"});
    model.result().numerical("av1").set("descr", new String[]{"Electric potential"});
    model.result().numerical("av1").set("unit", new String[]{"V"});
    model.result().table().create("tbl3", "Table");
    model.result().table("tbl3").comments("Line Average 1");
    model.result().numerical("av1").set("table", "tbl3");
    model.result().numerical("av1").setResult();
    model.result().numerical("av1").set("data", "dset2");
    model.result().table().create("tbl4", "Table");
    model.result().table("tbl4").comments("Line Average 1");
    model.result().numerical("av1").set("table", "tbl4");
    model.result().numerical("av1").setResult();
    model.result("pg3").run();
    model.result().create("pg4", "PlotGroup1D");
    model.result("pg4").run();
    model.result("pg4").create("glob1", "Global");
    model.result("pg4").feature("glob1").set("markerpos", "datapoints");
    model.result("pg4").feature("glob1").set("linewidth", "preference");
    model.result("pg4").feature("glob1").set("data", "dset2");
    model.result("pg4").feature("glob1").set("expr", new String[]{"es.fp1.V0"});
    model.result("pg4").feature("glob1").set("descr", new String[]{"Floating potential"});
    model.result("pg4").feature("glob1").set("unit", new String[]{"V"});
    model.result("pg4").run();
    model.result("pg4").feature("glob1").set("expr", new String[]{"es.fp2.V0"});
    model.result("pg4").feature("glob1").set("descr", new String[]{"Floating potential"});
    model.result("pg4").feature("glob1").set("unit", new String[]{"V"});
    model.result("pg4").feature("glob1").set("expr", new String[]{"es.fp1.V0"});
    model.result("pg4").feature("glob1").set("descr", new String[]{"Floating potential"});
    model.result("pg4").feature("glob1").set("unit", new String[]{"V"});
    model.result("pg4").feature("glob1").set("expr", new String[]{"es.fp2.V0"});
    model.result("pg4").feature("glob1").set("descr", new String[]{"Floating potential"});
    model.result("pg4").feature("glob1").set("unit", new String[]{"V"});
    model.result("pg4").feature("glob1").set("expr", new String[]{"es.fp2.V0", "es.fp1.V0"});
    model.result("pg4").feature("glob1").set("descr", new String[]{"Floating potential", "Floating potential"});
    model.result("pg4").run();

    model.label("SlidingMode_2D.mph");

    model.result("pg4").run();

    return model;
  }

  public static void main(String[] args) {
    run();
  }

}
