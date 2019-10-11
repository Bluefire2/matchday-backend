package main;

import util.Config;

public class Main {
    public static void main(String[] args) {
        Config config = Config.read(Main.class.getResourceAsStream("/config.toml"));
        System.out.println(config.getLeagues());
    }
}
