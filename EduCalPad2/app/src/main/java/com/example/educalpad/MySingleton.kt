package com.example.educalpad
    import android.content.Context
    import com.android.volley.Request
    import com.android.volley.RequestQueue
    import com.android.volley.toolbox.Volley


    //this is a singleton class used to create only a single instance
    class MySingleton constructor(context: Context) {
        companion object{
            @Volatile
            private var INSTANCE: MySingleton? = null
            fun getInstance(context: Context) =
                INSTANCE?: synchronized(this){
                    INSTANCE?: MySingleton(context).also {
                        INSTANCE = it
                    }
                }
        }

        //Volley library is used to make requestQueues
        private val requestQueue: RequestQueue by lazy {
            Volley.newRequestQueue(context.applicationContext)
        }
        fun<T> addToRequestQueue(req: Request<T>){
            requestQueue.add(req)
        }
    }