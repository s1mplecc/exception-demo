<template>
  <div class="hello">
    <table border="1">
      <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Age</th>
        <th>Phone</th>
      </tr>
      <tr v-for="user in users">
        <td>{{user.userId}}</td>
        <td>{{user.username}}</td>
        <td>{{user.age}}</td>
        <td>{{user.phone}}</td>
      </tr>
    </table>
    <form>
      <p><span>Username:</span><input type="text" v-model="user.username"/></p>
      <p><span>Age:</span><input type="text" v-model="user.age"/></p>
      <p><span>Phone:</span><input type="text" v-model="user.phone"/></p>
      <input type="submit" value="Register" v-on:click="register"/>
    </form>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    name: 'HelloWorld',
    data() {
      return {
        user: {
          username: null,
          phone: null,
          age: null
        },
        users: []
      }
    },
    methods: {
      register() {
        axios.post('http://localhost:8080/users', this.user)
          .then(() => {
            alert('Success!')
            this.loadUsers()
          })
          .catch((err) => {
            alert(err.response.data.message)
          })
      },
      loadUsers() {
        axios.get('http://localhost:8080/users')
          .then(res => this.users = res.data)
      }
    },
    created() {
      this.loadUsers()
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  p {
    height: 12px;
  }

  p span {
    width: 100px;
    display: inline-block;
  }

  table {
    font-family: verdana, arial, sans-serif;
    font-size: 11px;
    color: #333333;
    border-collapse: collapse;
    margin: 0 auto;
  }

  table th {
    padding: 8px;
    background-color: #dedede;
  }

  table td {
    padding: 8px;
    background-color: #ffffff;
  }
</style>
