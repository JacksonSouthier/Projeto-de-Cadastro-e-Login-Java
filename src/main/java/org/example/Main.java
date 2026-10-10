package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
static void main() {
BancoDeDados bd = new BancoDeDados();
Controller c = new Controller(bd);

bd.criarDATABASE();
c.menuPrincipal();

}
}
