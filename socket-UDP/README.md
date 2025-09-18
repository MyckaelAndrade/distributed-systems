# 🌡️ Sistema de Sensores UDP – Java

Este projeto simula um sistema distribuído onde múltiplos sensores (clientes) enviam leituras de temperatura e umidade para um servidor central via UDP. O servidor exibe em tempo real as últimas leituras recebidas de cada sensor.

---

## 🚀 Como funciona?

- **Sensor (Cliente):**  
  Gera valores aleatórios de temperatura e umidade e envia para o servidor UDP a cada segundo.

- **Servidor:**  
  Recebe os dados de todos os sensores e exibe as leituras mais recentes de cada um.

---

## 📁 Estrutura dos Arquivos

```
socket-UDP/
├── Sensor.java      // Código do cliente (sensor)
└── Servidor.java    // Código do servidor UDP
```

---

## ⚙️ Como executar

### 1️⃣ Compile os arquivos

Abra o terminal na pasta do projeto e execute:

```sh
javac Servidor.java Sensor.java
```

### 2️⃣ Inicie o servidor

```sh
java Servidor
```

Você verá:
```
Servidor UDP escutando na porta 9876
```

### 3️⃣ Inicie um ou mais sensores

Em outro terminal (ou várias vezes para simular vários sensores):

```sh
java Sensor
```

---

## 📝 Exemplo de saída do servidor

```
Servidor UDP escutando na porta 9876
Leituras atuais:
Sensor 1 -> Temperatura: 32.5C | Umidade: 65.2%
-----------------------------
Sensor 1 -> Temperatura: 31.1C | Umidade: 60.7%
Sensor 2 -> Temperatura: 28.4C | Umidade: 55.3%
-----------------------------
```

---

## 🧑‍💻 Personalização

- Para simular múltiplos sensores, altere o valor de `SENSOR_ID` no arquivo `Sensor.java` antes de rodar cada instância.
- O intervalo de envio pode ser ajustado alterando o valor do `Thread.sleep(1000)`.

---

## ❓ Por que UDP?

- 📡 Baixa latência
- 🔄 Atualizações rápidas e contínuas
- 🏃‍♂️ Não exige confirmação de recebimento (ideal para dados em tempo real)

---

## 🏆 Créditos

Desenvolvido para a disciplina de **Sistemas Distribuídos**.

---
