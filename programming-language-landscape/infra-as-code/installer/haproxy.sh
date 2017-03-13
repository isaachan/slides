export PATH=$PATH:/usr/bin
# install haproxy 1.5
sudo add-apt-repository -y ppa:vbernat/haproxy-1.5
sudo apt-get update
sudo apt-get -y install haproxy

# download haproxy conf
sudo wget https://gist.githubusercontent.com/thisismitch/91815a582c27bd8aa44d/raw/8fc59b7cb88a2be9b802cd76288ca1c2ea957dd9/haproxy.cfg -O /etc/haproxy/haproxy.cfg

# replace ip address variables in haproxy conf to use droplet ip addresses
sudo sed -i "s/HAPROXY_PUBLIC_IP/$1/g" /etc/haproxy/haproxy.cfg
sudo sed -i "s/WWW_1_PRIVATE_IP/$2/g" /etc/haproxy/haproxy.cfg
sudo sed -i "s/WWW_2_PRIVATE_IP/$3/g" /etc/haproxy/haproxy.cfg

# restart haproxy to load changes
sudo service haproxy restart
