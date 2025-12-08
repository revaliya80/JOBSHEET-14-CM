import java.util.Scanner;

public class CM2Beasiswa24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // deklarasi array
        String[] nama = new String[100];
        String[] nim = new String[100];
        double[] ipk = new double[100];
        String[] jenis = new String[100];
        int[] penghasilan = new int[100];

        int jumlah = 0;
        int pilih;

        do {
            // tampilan menu
            System.out.println("=== Sistem Pendaftaran Beasiswa ===");
            System.out.println("1. Nama Mahasiswa");
            System.out.println("2. Tampilkan semua pendaftar");
            System.out.println("3. Cari pendaftar berdasarkan jenis beasiswa");
            System.out.println("4. Hitung rata-rata IPK per jenis beasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu(1-5): ");
            pilih = sc.nextInt();

            // pilihan menu 1
            if (pilih == 1) {
                sc.nextLine();
                System.out.print("Nama Mahasiswa: ");
                nama[jumlah] = sc.nextLine();
                System.out.print("NIM: ");
                nim[jumlah] = sc.nextLine();
                System.out.print("IPK: ");
                String ipkinput = sc.nextLine();
                ipk[jumlah] = Double.parseDouble(ipkinput);

                System.out.print("Jenis (Reguler/Unggulan/Riset): ");
                jenis[jumlah] = sc.nextLine();

                if (!jenis[jumlah].equalsIgnoreCase("Reguler") && !jenis[jumlah].equalsIgnoreCase("Unggulan")
                        && !jenis[jumlah].equalsIgnoreCase("Riset")) {
                    System.out.println("Jenis salah!");
                    continue;
                }

                System.out.print("Penghasilan orang tua (maksimal 2000000): ");
                penghasilan[jumlah] = sc.nextInt();
                sc.nextLine();

                if (penghasilan[jumlah] > 2000000) {
                    System.out.println("Pendaftaran dibatalkan karena penghasilan melebihi batas maksimal");
                    continue;
                }

                jumlah++;
                System.out.println("Pendaftar berhasil disimpan. Total pendaftar: " + jumlah);

                // pilihan menu 2
            } else if (pilih == 2) {
                if (jumlah == 0) {
                    System.out.println("Belum ada pendaftar.");
                } else {
                    for (int i = 0; i < jumlah; i++) {
                        System.out.println(
                                (i + 1) + ". " + nama[i] + " - " + nim[i] + "- IPK: " + ipk[i] + "- " + jenis[i]);
                    }
                }

                // pilihan menu 3
            } else if (pilih == 3) {
                System.out.print("Jenis dicari: ");
                String cari = sc.nextLine();
                boolean ketemu = false;

                for (int i = 0; i < jumlah; i++) {
                    if (jenis[i].equalsIgnoreCase(cari)) {
                        System.out.println(nama[i] + " - " + nim[i] + "- IPK: " + ipk[i]);
                        ketemu = true;
                    }
                }
                if (!ketemu)
                    System.out.println("Tidak ada data.");

                // pilihan menu 4
            } else if (pilih == 4) {
                double Reguler = 0, unggulan = 0, riset = 0;
                int nReguler = 0, nUnggulan = 0, nRiset = 0;

                for (int i = 0; i < jumlah; i++) {
                    if (jenis[i].equalsIgnoreCase("Reguler")) {
                        Reguler += ipk[i];
                        nReguler++;
                    }
                    if (jenis[i].equalsIgnoreCase("Unggulan")) {
                        unggulan = 0;
                        nUnggulan++;
                    }
                    if (jenis[i].equalsIgnoreCase("Riset")) {
                        riset = 0;
                        nRiset++;
                    }
                }
                if (nReguler == 0) {
                    System.out.println("Reguler: tidak ada");
                } else {
                    System.out.println("Reguler\t\t: " + (Reguler / nReguler));
                }

                if (nUnggulan == 0) {
                    System.out.println("Unggulan\t\t: tidak ada");
                } else {
                    System.out.println("Unggulan\t\t: " + (unggulan / nUnggulan));
                }

                if (nRiset == 0) {
                    System.out.println("Riset: tidak ada");
                } else {
                    System.out.println("Riset\t\t: " + (riset / nRiset));
                }
            }
        } while (pilih != 5);

        // program selesai
        System.out.println("Program selesai.");
        sc.close();
    }
}
// https://github.com/revaliya80/JOBSHEET-14-CM