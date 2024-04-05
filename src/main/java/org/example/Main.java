package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing VersionManager");

        VersionManager vm = new VersionManager();
        vm.updateVersion(ETypeUpdate.MAJEUR);
        System.out.println(vm.getVersion());

    }
}