package com.example.demo.Main;

//import com.sun.tools.attach.VirtualMachine;
//import com.sun.tools.attach.VirtualMachineDescriptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class ArthasLauncher {

    public static void main(String[] args) {
        String javaHome = System.getProperty("java.home");
        String arthasJarPath = "/Users/admin/Desktop/tools/arthas-boot.jar"; // 替换为实际路径

        // Step 1: List Java processes
//        List<VirtualMachineDescriptor> vmList = VirtualMachine.list();
//        System.out.println("Select a Java process to attach:");
//        for (int i = 0; i < vmList.size(); i++) {
//            System.out.println("[" + i + "]: " +vmList.get(i).id()+" "+ vmList.get(i).displayName());
//        }

        // 从用户获取 PID
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入目标 JVM 的进程 ID: ");
        String targetPid = scanner.nextLine();

        // 获取是否需要执行命令或批处理文件
        System.out.print("是否需要执行命令? (y/n): ");
        String executeCommand = scanner.nextLine().trim().toLowerCase();

        String commandString = "";
        if ("y".equals(executeCommand)) {
            System.out.print("请输入要执行的命令（多个命令用分号分隔）: ");
            commandString = scanner.nextLine().trim();
        }

        // 构建命令
        String[] command;
        if (!commandString.isEmpty()) {
            command = new String[]{
                    javaHome + "/bin/java",
                    "-jar",
                    arthasJarPath,
                    "-c",
                    commandString,
                    targetPid
            };
        } else {
            command = new String[]{
                    javaHome + "/bin/java",
                    "-jar",
                    arthasJarPath,
                    targetPid
            };
        }

        try {
            Process process = new ProcessBuilder(command).start();
            printProcessOutput(process.getInputStream(), "OUTPUT");
            printProcessOutput(process.getErrorStream(), "ERROR");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printProcessOutput(InputStream inputStream, String label) {
        new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(label + ": " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}