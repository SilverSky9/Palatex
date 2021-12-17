<template>
  <div class="container-fluid">
    <div class="row mr-2">
      <NuxtLink
        to="/"
        class="col-sm-auto p-3 rounded-circle m-2 icon"
        title=""
        data-bs-toggle="tooltip"
        data-bs-placement="right"
        data-bs-original-title="Home"
      >
        <fa :icon="['fa', 'eraser']" size="2x" color="white" />
      </NuxtLink>
      <div class="col-sm my-2 header">
        <span class="headerText py-0 pr-0 text-white">Palatex</span>
        <span class="text-secondary">Buying and Selling Latex Product</span>
      </div>
    </div>
    <div class="row positon-sticky">
      <div class="col-sm-auto p-0">
        <div>
          <ul
            class="
              nav nav-pills nav-flush
              flex-sm-column flex-row flex-nowrap
              mb-auto
              mt-3
              mx-0
              text-center
              align-items-center
            "
          >
            <li class="pl-2 iconEffect">
              <NuxtLink
                to="/Profile"
                class="nav-link py-3"
                title=""
                data-bs-toggle="tooltip"
                data-bs-placement="right"
              >
                <fa :icon="['fa', 'user-alt']" size="2x" />
              </NuxtLink>
            </li>
            <li class="pl-2 iconEffect">
              <NuxtLink
                to="/Analysis"
                class="nav-link py-3"
                title=""
                data-bs-toggle="tooltip"
                data-bs-placement="right"
              >
                <fa :icon="['fa', 'chart-bar']" size="2x" />
              </NuxtLink>
            </li>
            <li class="pl-2 iconEffect">
              <NuxtLink
                to="/Transection"
                class="nav-link py-3"
                title=""
                data-bs-toggle="tooltip"
                data-bs-placement="right"
              >
                <fa :icon="['fa', 'exchange-alt']" size="2x" />
              </NuxtLink>
            </li>
            <li class="pl-2 iconEffect">
              <NuxtLink
                to="/Sheet"
                class="nav-link py-3"
                title=""
                data-bs-toggle="tooltip"
                data-bs-placement="right"
              >
                <fa :icon="['fa', 'layer-group']" size="2x" />
              </NuxtLink>
            </li>
            <li class="pl-2 iconEffect">
              <NuxtLink
                to="/Login"
                class="nav-link py-3"
                title=""
                data-bs-toggle="tooltip"
                data-bs-placement="right"
              >
                <fa :icon="['fa', 'sign-in-alt']" size="2x" />
              </NuxtLink>
            </li>
            <li class="pl-2 iconEffect" @click="signout()">
              <fa :icon="['fa', 'sign-out-alt']" size="2x" />
            </li>
            <li class="pl-2 iconEffect" @click="localStatus()">
              <fa :icon="['fa', 'exchange-alt']" size="2x" />
            </li>
          </ul>
        </div>
      </div>
      <div class="col-sm min-vh-100">
        <Nuxt />
        <div
          v-show="isVisible"
          class="scrollup-button bg-light"
          @click="scrollToTop"
        >
          <fa :icon="['fa', 'arrow-up']" size="2x" />
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { debounce } from 'vue-debounce'
export default {
  data() {
    return {
      scrollTop: null,
      isVisible: false,
      visibleDistance: 200,
    }
  },
  mounted() {
    // this.startFetching()
  },
  created() {
    this.startFetching()
  },
  beforeDestroy() {
    window.removeEventListener('scroll', this.scrollListener)
  },
  methods: {
    async startFetching() {
      this.isLogin()
      this.localStatus()
      window.addEventListener(
        'scroll',
        debounce(this.scrollListener, 100),
        true
      )

      console.log(this.$store.state.header_token)
    },
    async localStatus() {
      console.log('token: ' + localStorage.getItem('token'))
      console.log('islogged: ' + localStorage.getItem('isLogged'))
      console.log('isAdmin: ' + localStorage.getItem('isAdmin'))
      await this.$store.commit(
        'set_header_token',
        localStorage.getItem('token')
      )
    },
    async signout() {
      console.log('logged out')
      localStorage.setItem('token', '')
      localStorage.setItem('isLogged', false)
      localStorage.setItem('isAdmin', false)
      this.$store.commit('set_header_token', '')
    },
    isLogin: () => {
      var token
      token = localStorage.getItem('token')
      if (token == '') {
        console.log('no token')
        localStorage.setItem('isLogged', false)
        localStorage.setItem('isAdmin', false)
        this.$store.commit('set_header_token', '')
      } else {
      }
    },
    scrollListener() {
      if (window.pageYOffset) {
        this.scrollTop = window.pageYOffset
      } else {
        this.scrollTop = 0
      }
      if (this.scrollTop > this.visibleDistance) {
        this.isVisible = true
      } else {
        this.isVisible = false
      }
    },
    scrollToTop() {
      this.intervalId = setInterval(() => {
        if (window.pageYOffset === 0) {
          clearInterval(this.intervalId)
        }
        window.scroll(0, window.pageYOffset - 200)
      }, 10)
    },
  },
}
</script>
<style >
.scrollup-button {
  position: fixed;
  bottom: 4rem;
  right: 2rem;
  cursor: pointer;
  border-radius: 0.25rem;
  opacity: 0.6;
  padding: 0.5rem;
  z-index: 1000;
  transition: opacity 0.15s ease;
}
.scrollup-button:hover {
  opacity: 0.9;
}
fa {
  width: 2rem;
  height: 2rem;
}

.nav-link {
  color: #9f9f9f;
}
.nav-link:hover {
  color: #000;
}
.header {
  border-radius: 10rem;
  font-family: 'Kanit';
  background-color: black;
}
.headerText {
  padding: 1rem;
  font-size: 2.6rem;
}
.iconEffect {
  background: linear-gradient(to left, rgba(255, 255, 255, 0));
  -webkit-animation-duration: 0.3s;
  animation-duration: 0.3s;
  -webkit-animation-fill-mode: both;
  animation-fill-mode: both;
  -webkit-animation-timing-function: ease-in-out;
  animation-timing-function: ease-in-out;
}
.iconEffect:hover {
  /* background: linear-gradient(to left, #fff, #fff 85%, #000 85%); */
  animation-name: leftStoke;
  -moz-animation-name: leftStoke;
}
.icon {
  background-color: black;
  -webkit-animation-duration: 1s;
  animation-duration: 1s;
  -webkit-animation-fill-mode: both;
  animation-fill-mode: both;
  -webkit-animation-timing-function: ease-in-out;
  animation-timing-function: ease-in-out;
  animation-iteration-count: infinite;
  -webkit-animation-iteration-count: infinite;
}
.icon:hover {
  animation-name: bounce;
  -moz-animation-name: bounce;
}
@keyframes bounce {
  0%,
  100%,
  5%,
  50%,
  80% {
    -webkit-transform: translateY(0);
    -ms-transform: translateY(0);
    transform: translateY(0);
  }
  40% {
    -webkit-transform: translateY(-30px);
    -ms-transform: translateY(-30px);
    transform: translateY(-30px);
  }
  60% {
    -webkit-transform: translateY(-15px);
    -ms-transform: translateY(-15px);
    transform: translateY(-15px);
  }
}
@keyframes leftStoke {
  0% {
    background-position-x: 0px;
    /* opacity: 0; */
    background: linear-gradient(to left, rgba(255, 255, 255, 0));
  }

  50% {
    -webkit-transform: translateX(-15px);
    -ms-transform: translateX(-15px);
    background-position-x: 0rem;
  }
  100% {
    background-position-x: 0rem;
    background: linear-gradient(
      to left,
      rgba(255, 255, 255, 0),
      rgba(255, 255, 255, 0) 85%,
      #000 85%
    );
  }
}
</style>