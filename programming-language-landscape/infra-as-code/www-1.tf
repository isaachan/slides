resource "digitalocean_droplet" "www-1" {

    image = "ubuntu-14-04-x64"
    name = "www-1"
    region = "nyc2"
    size = "512mb"
    private_networking = true
    ssh_keys = [
        "${var.ssh_fingerprint}"
    ]

    connection {
        user = "root"
        type = "ssh"
        key_file = "${var.pvt_key}"
        agent = true
        timeout = "2m"
    }

    provisioner "file" {
        source = "installer/nginx.sh"
        destination = "/tmp/nginx.sh"
    }

    provisioner "remote-exec" {
        inline = [
            "sudo bash /tmp/nginx.sh"
        ]
    }
}
