resource "digitalocean_droplet" "haproxy-www" {
    image = "ubuntu-14-04-x64"
    name = "haproxy-www"
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
        timeout = "2m"
    }

    provisioner "file" {
        source = "installer/haproxy.sh"
        destination = "/tmp/haproxy.sh"
    }

    provisioner "remote-exec" {
        inline = [
            "sudo chmod +x /tmp/haproxy.sh",
            "sudo /tmp/haproxy.sh ${digitalocean_droplet.haproxy-www.ipv4_address} ${digitalocean_droplet.www-1.ipv4_address_private} ${digitalocean_droplet.www-2.ipv4_address_private}"
        ]
    }
}
